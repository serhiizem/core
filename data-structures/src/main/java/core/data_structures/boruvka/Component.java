package core.data_structures.boruvka;

import java.util.ArrayList;
import java.util.List;

public class Component {

    /**
     * A unique identifier for this component in the graph that contains
     * it.
     */
    public final int nodeId;
    /**
     * List of edges attached to this component, sorted by weight from least
     * to greatest.
     */
    public List<BoruvkaEdge> edges = new ArrayList<>();
    /**
     * The weight this component accounts for. A component gains weight when
     * it is merged with another component across an edge with a certain
     * weight.
     */
    public double totalWeight = 0;
    /**
     * Number of edges that have been collapsed to create this component.
     */
    public long totalEdges = 0;
    /**
     * Whether this component has already been collapsed into another
     * component.
     */
    public boolean isDead = false;

    public Component(int nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * Edge is inserted in weight order, from least to greatest.
     */
    public void addEdge(BoruvkaEdge e) {
        int i = 0;
        while (i < edges.size()) {
            if (e.getWeight() < edges.get(i).getWeight()) {
                break;
            }
            i++;
        }
        edges.add(i, e);
    }

    /**
     * Get the edge with minimum weight from the sorted edge list.
     *
     * @return Edge with the smallest weight attached to this component.
     */
    public BoruvkaEdge getMinEdge() {
        if (edges.size() == 0) {
            return null;
        }
        return edges.get(0);
    }

    public void merge(final Component other, final double edgeWeight) {
        totalWeight += other.totalWeight + edgeWeight;
        totalEdges += other.totalEdges + 1;
        final List<BoruvkaEdge> newEdges = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i + j < edges.size() + other.edges.size()) {
            while (i < edges.size()) {
                final BoruvkaEdge e = edges.get(i);
                if ((e.getFromComponent() != this && e.getFromComponent() != other)
                        || (e.getFromComponent() != this && e.getToComponent() != other)
                ) {
                    break;
                }
                i++;
            }
            while (j < other.edges.size()) {
                final BoruvkaEdge e = other.edges.get(j);
                if ((e.getFromComponent() != this && e.getFromComponent() != other)
                        || (e.getToComponent() != this && e.getToComponent() != other)
                ) {
                    break;
                }
                j++;
            }
            if (j < other.edges.size() && (i >= edges.size()
                    || edges.get(i).getWeight() > other.edges.get(j).getWeight())
            ) {
                newEdges.add(other.edges.get(j++).replaceComponent(other,
                        this));
            } else if (i < edges.size()) {
                newEdges.add(edges.get(i++).replaceComponent(other, this));
            }
        }
        other.edges.clear();
        edges.clear();
        edges = newEdges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Component)) {
            return false;
        }

        final Component component = (Component) o;

        return nodeId == component.nodeId;
    }

    @Override
    public int hashCode() {
        return nodeId;
    }

    @Override
    public String toString() {
        return "Component{" +
                "nodeId=" + nodeId + ", " +
                "edges=" + "\n" + getEdgesString() +
                "totalWeight=" + totalWeight + ", " +
                "totalEdges=" + totalEdges + ", " +
                "isDead=" + isDead +
                '}';
    }

    private String getEdgesString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < edges.size(); i++) {
            sb.append("\t\t");
            sb.append(edges.get(i));
            if (i == edges.size() - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
