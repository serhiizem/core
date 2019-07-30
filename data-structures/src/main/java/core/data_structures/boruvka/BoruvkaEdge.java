package core.data_structures.boruvka;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.Integer.compare;

@Getter
@AllArgsConstructor
public class BoruvkaEdge implements Comparable<BoruvkaEdge> {

    /**
     * Source component.
     */
    private Component fromComponent;
    /**
     * Destination component.
     */
    private Component toComponent;
    /**
     * Weight of this edge.
     */
    private int weight;

    public Component getOther(Component from) {
        if (fromComponent == from) {
            return toComponent;
        }
        if (toComponent == from) {
            return fromComponent;
        }
        return null;
    }

    @Override
    public int compareTo(BoruvkaEdge e) {
        return compare(weight, e.weight);
    }

    public BoruvkaEdge replaceComponent(Component from, Component to) {
        if (fromComponent == from) {
            fromComponent = to;
        }
        if (toComponent == from) {
            toComponent = to;
        }
        return this;
    }

    @Override
    public String toString() {
        return "fromComponent=" + fromComponent.nodeId +
                ", toComponent=" + toComponent.nodeId +
                ", weight=" + weight +
                '}';
    }
}
