package core.data_structures;

public class TestData {

    private static final int UNWEIGHTED = 1;

    static class ArtificiallyUndirected {

        static final WeightedDirectedGraph TEST_GRAPH_1 = new WeightedDirectedGraph();

        static {
            createFirstGraph();
        }

        private static void createFirstGraph() {
            TEST_GRAPH_1.addVertex(0);
            TEST_GRAPH_1.addVertex(1);
            TEST_GRAPH_1.addVertex(2);
            TEST_GRAPH_1.addVertex(3);
            TEST_GRAPH_1.addVertex(4);
            TEST_GRAPH_1.addVertex(5);

            TEST_GRAPH_1.addEdge(0, 1, 4);
            TEST_GRAPH_1.addEdge(1, 0, 4);
            TEST_GRAPH_1.addEdge(0, 2, 3);
            TEST_GRAPH_1.addEdge(2, 0, 3);
            TEST_GRAPH_1.addEdge(1, 2, 5);
            TEST_GRAPH_1.addEdge(2, 1, 5);
            TEST_GRAPH_1.addEdge(1, 3, 2);
            TEST_GRAPH_1.addEdge(3, 1, 2);
            TEST_GRAPH_1.addEdge(3, 4, 2);
            TEST_GRAPH_1.addEdge(4, 3, 2);
            TEST_GRAPH_1.addEdge(4, 1, 4);
            TEST_GRAPH_1.addEdge(1, 4, 4);
            TEST_GRAPH_1.addEdge(4, 5, 6);
            TEST_GRAPH_1.addEdge(5, 4, 6);
            TEST_GRAPH_1.addEdge(4, 0, 4);
            TEST_GRAPH_1.addEdge(0, 4, 4);
        }
    }

    static class WithNoCycles {

        static final WeightedDirectedGraph TEST_GRAPH_1 = new WeightedDirectedGraph();

        static {
            createFirstGraph();
        }

        private static void createFirstGraph() {
            TEST_GRAPH_1.addVertex(0);
            TEST_GRAPH_1.addVertex(1);
            TEST_GRAPH_1.addVertex(2);
            TEST_GRAPH_1.addVertex(3);

            TEST_GRAPH_1.addEdge(0, 1, UNWEIGHTED);
            TEST_GRAPH_1.addEdge(1, 2, UNWEIGHTED);
            TEST_GRAPH_1.addEdge(2, 3, UNWEIGHTED);
        }
    }

    static class WithCycles {

        static final WeightedDirectedGraph TEST_GRAPH_1 = new WeightedDirectedGraph();
        static final WeightedDirectedGraph TEST_GRAPH_2 = new WeightedDirectedGraph();
        static final WeightedDirectedGraph TEST_GRAPH_3 = new WeightedDirectedGraph();

        static {
            createFirstGraph();
            createSecondGraph();
            createThirdGraph();
        }

        private static void createFirstGraph() {
            TEST_GRAPH_1.addVertex(0);
            TEST_GRAPH_1.addVertex(1);
            TEST_GRAPH_1.addVertex(2);
            TEST_GRAPH_1.addVertex(3);
            TEST_GRAPH_1.addVertex(4);
            TEST_GRAPH_1.addVertex(5);

            TEST_GRAPH_1.addEdge(0, 1, 4);
            TEST_GRAPH_1.addEdge(0, 2, 3);
            TEST_GRAPH_1.addEdge(1, 2, 5);
            TEST_GRAPH_1.addEdge(1, 3, 2);
            TEST_GRAPH_1.addEdge(3, 4, 2);
            TEST_GRAPH_1.addEdge(4, 1, 4);
            TEST_GRAPH_1.addEdge(4, 5, 6);
            TEST_GRAPH_1.addEdge(4, 0, 4);
        }

        private static void createThirdGraph() {
            TEST_GRAPH_3.addVertex(0);
            TEST_GRAPH_3.addVertex(1);
            TEST_GRAPH_3.addVertex(2);
            TEST_GRAPH_3.addVertex(3);
            TEST_GRAPH_3.addVertex(4);
            TEST_GRAPH_3.addVertex(5);

            TEST_GRAPH_3.addEdge(0, 1, 4);
            TEST_GRAPH_3.addEdge(0, 2, 3);
            TEST_GRAPH_3.addEdge(1, 3, 2);
            TEST_GRAPH_3.addEdge(1, 2, 1);
            TEST_GRAPH_3.addEdge(2, 3, 4);
            TEST_GRAPH_3.addEdge(3, 4, 2);
            TEST_GRAPH_3.addEdge(4, 5, 6);
        }

        static void createSecondGraph() {
            TEST_GRAPH_2.addVertex(0);
            TEST_GRAPH_2.addVertex(1);
            TEST_GRAPH_2.addVertex(2);
            TEST_GRAPH_2.addVertex(3);
            TEST_GRAPH_2.addVertex(4);

            TEST_GRAPH_2.addEdge(0, 1, UNWEIGHTED);
            TEST_GRAPH_2.addEdge(0, 2, UNWEIGHTED);
            TEST_GRAPH_2.addEdge(1, 3, UNWEIGHTED);
            TEST_GRAPH_2.addEdge(2, 3, UNWEIGHTED);
            TEST_GRAPH_2.addEdge(3, 4, UNWEIGHTED);
        }
    }

    private TestData() {
    }
}
