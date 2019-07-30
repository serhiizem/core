package core.data_structures.boruvka;

import core.data_structures.Queue;
import core.data_structures.WeightedDirectedGraph;

public class BoruvkaMST {

    private BoruvkaComponentsProducer componentsProducer = new BoruvkaComponentsProducer();

    public Component calculate(WeightedDirectedGraph graph) {
        Queue<Component> components = componentsProducer.getComponents(graph);

        Component loopNode = null;
        while (!components.isEmpty()) {

            loopNode = components.dequeue();

            if (loopNode.isDead) {
                continue; // node loopNode has already been merged
            }

            BoruvkaEdge e = loopNode.getMinEdge();
            if (e == null) {
                break; // done - graph is contracted to a single node
            }

            Component other = e.getOther(loopNode);
            other.isDead = true;
            // merge node other into node loopNode
            loopNode.merge(other, e.getWeight());
            // add newly merged loopNode back in the work-list
            components.enqueue(loopNode);
        }

        return loopNode;
    }
}
