package core.data_structures.boruvka;

import core.data_structures.Queue;
import core.data_structures.WeightedDirectedGraph;
import core.data_structures.WeightedDirectedGraph.Edge;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class BoruvkaComponentsProducer {

    public Queue<Component> getComponents(WeightedDirectedGraph graph) {

        Map<Integer, Component> componentsMap = getMapOfSrcComponents(graph);

        Queue<Component> result = new Queue<>();

        Collection<Component> components = componentsMap.values();
        for (Component component : components) {
            List<BoruvkaEdge> edges = component.edges;
            for (BoruvkaEdge edge : edges) {
                Component toComponent = edge.getToComponent();
                Component wiredComponent = componentsMap.get(toComponent.nodeId);
                toComponent.edges.addAll(wiredComponent.edges);
            }
            result.enqueue(component);
        }

        return result;
    }

    private Map<Integer, Component> getMapOfSrcComponents(WeightedDirectedGraph graph) {
        return graph.getVertices()
                .entrySet()
                .stream()
                .collect(toMap(Entry::getKey, toComponent));
    }

    private Function<Entry<Integer, List<Edge>>, Component> toComponent = entry -> {
        Integer vertex = entry.getKey();
        List<Edge> edges = entry.getValue();

        Component srcComponent = new Component(vertex);
        for (Edge outgoingEdge : edges) {
            Integer dest = outgoingEdge.getDest();

            Component destComponent = new Component(dest);
            BoruvkaEdge boruvkaEdge = new BoruvkaEdge(srcComponent, destComponent, outgoingEdge.getWeight());
            srcComponent.addEdge(boruvkaEdge);
        }

        return srcComponent;
    };
}
