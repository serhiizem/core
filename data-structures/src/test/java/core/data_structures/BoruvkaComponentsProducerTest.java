package core.data_structures;

import core.data_structures.boruvka.BoruvkaComponentsProducer;
import core.data_structures.boruvka.BoruvkaEdge;
import core.data_structures.boruvka.Component;
import org.junit.jupiter.api.Test;

import java.util.List;

import static core.data_structures.TestData.ArtificiallyUndirected.TEST_GRAPH_1;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BoruvkaComponentsProducerTest {

    private BoruvkaComponentsProducer producer = new BoruvkaComponentsProducer();

    @Test
    void shouldPopulateArrayOfNeighboringComponents() {
        Queue<Component> components = producer.getComponents(TEST_GRAPH_1);

        for (Component component : components) {
            List<BoruvkaEdge> edges = component.edges;
            for (BoruvkaEdge edge : edges) {
                Component toComponent = edge.getToComponent();
                List<BoruvkaEdge> destEdges = toComponent.edges;
                assertThat(destEdges, is(not(empty())));
            }
        }
    }
}