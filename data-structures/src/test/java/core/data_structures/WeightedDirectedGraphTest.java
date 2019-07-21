package core.data_structures;

import core.data_structures.WeightedDirectedGraph.Edge;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeightedDirectedGraphTest {

    @Test
    void shouldFindAllTheAdjacentVertices() {
        List<Integer> adjacentVertices = TestData.WithCycles.TEST_GRAPH_1.getAdjacentVertices(4);

        assertThat(adjacentVertices, containsInAnyOrder(0, 1, 5));
    }

    @Test
    void shouldFindCyclesIfThereAreCycles() {
        boolean hasCycles = TestData.WithCycles.TEST_GRAPH_1.hasCycles();

        assertTrue(hasCycles);
    }

    @Test
    void shouldFindCyclesIfThereAreCyclesForOtherGraph() {
        boolean hasCycles = TestData.WithCycles.TEST_GRAPH_2.hasCycles();

        assertTrue(hasCycles);
    }

    @Test
    void shouldNotFindCyclesIfThereAreNoCycles() {
        boolean hasCycles = TestData.WithNoCycles.TEST_GRAPH_1.hasCycles();

        assertFalse(hasCycles);
    }

    @Test
    void shouldFindMinimumSpanningTree() {
        List<Edge> edges = TestData.WithCycles.TEST_GRAPH_3.mstKruskal();

        Edge[] correctMST = new Edge[]{
                new Edge(0, 2, 3),
                new Edge(1, 2, 1),
                new Edge(1, 3, 2),
                new Edge(3, 4, 2),
                new Edge(4, 5, 6)
        };

        assertThat(edges, containsInAnyOrder(correctMST));
    }
}