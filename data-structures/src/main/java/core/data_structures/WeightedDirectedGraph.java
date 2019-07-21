package core.data_structures;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.*;

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

        List<Edge> allEdges = vertices.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(toList());

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

    @EqualsAndHashCode
    @RequiredArgsConstructor
    public static class Edge {
        final Integer src;
        final Integer dest;
        final Integer wight;
    }
}
