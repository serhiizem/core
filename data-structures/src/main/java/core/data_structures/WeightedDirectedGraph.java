package core.data_structures;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

@SuppressWarnings("WeakerAccess")
public class WeightedDirectedGraph {

    private Map<Integer, List<Edge>> vertices = new HashMap<>();

    WeightedDirectedGraph() {
    }

    public void addVertex(Integer vertex) {
        vertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Integer src, Integer dest, Integer weight) {
        Edge edge = new Edge(src, dest, weight);
        vertices.get(src).add(edge);
    }

    public List<Edge> mstKruskal() {
        Deque<Edge> edges = getEdgesSortedByWeight();

        Integer[] relationshipsArray = createRelationshipsArray();

        List<Edge> mst = new ArrayList<>();

        int index = 0;

        while (index < vertices.size() - 1) {
            Edge edge = edges.pollFirst();

            if (edge != null) {
                Integer src = edge.getSrc();
                Integer dest = edge.getDest();

                Integer parentSrc = find(relationshipsArray, src);
                Integer parentDest = find(relationshipsArray, dest);

                if (!parentSrc.equals(parentDest)) {
                    mst.add(edge);
                    union(relationshipsArray, parentSrc, parentDest);
                    index++;
                }
            }
        }

        return mst;
    }

    private Deque<Edge> getEdgesSortedByWeight() {
        return getAllEdges()
                .stream()
                .sorted(comparing(Edge::getWeight))
                .collect(toCollection(ArrayDeque::new));
    }

    public List<Integer> getAdjacentVertices(Integer vertex) {
        List<Edge> edges = vertices.get(vertex);

        List<Integer> adjacentVertices = new ArrayList<>();
        for (Edge edge : edges) {
            Integer dest = edge.dest;
            adjacentVertices.add(dest);
        }
        return adjacentVertices;
    }

    public boolean hasCycles() {
        Integer[] relationshipsArray = createRelationshipsArray();

        List<Edge> allEdges = getAllEdges();

        for (Edge edge : allEdges) {
            Integer src = edge.src;
            Integer dest = edge.dest;

            Integer srcParent = find(relationshipsArray, src);
            Integer destParent = find(relationshipsArray, dest);

            if (srcParent.equals(destParent)) {
                return true;
            }

            union(relationshipsArray, srcParent, destParent);
        }

        return false;
    }

    private List<Edge> getAllEdges() {
        return vertices.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(toList());
    }

    private Integer[] createRelationshipsArray() {
        int verticesNumber = vertices.size();

        Integer[] parents = new Integer[verticesNumber];
        for (int i = 0; i < verticesNumber; i++) {
            parents[i] = i;
        }
        return parents;
    }

    private Integer find(Integer[] relationshipsArray, Integer vertex) {
        Integer parent = relationshipsArray[vertex];
        if (!parent.equals(vertex)) {
            return find(relationshipsArray, parent);
        }
        return parent;
    }

    private void union(Integer[] relationshipsArray, Integer src, Integer dest) {
        Integer srcParent = find(relationshipsArray, src);
        Integer destParent = find(relationshipsArray, dest);

        relationshipsArray[destParent] = srcParent;
    }

    @Getter
    @ToString
    @EqualsAndHashCode
    @RequiredArgsConstructor
    public static class Edge {
        final Integer src;
        final Integer dest;
        final Integer weight;
    }
}
