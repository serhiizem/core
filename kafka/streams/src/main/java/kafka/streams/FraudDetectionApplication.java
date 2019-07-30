package kafka.streams;

import kafka.common.model.Order;
import kafka.streams.serde.OrderSerde;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.ValueMapper;

import java.util.Properties;

@Slf4j
public class FraudDetectionApplication {

    public static void main(String[] args) {
        Properties props = new Properties();

        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "fraud-detection-application");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093, localhost:9094");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, OrderSerde.class);

        StreamsBuilder streamsBuilder = new StreamsBuilder();

        KStream<String, Order> payments = streamsBuilder.stream("payments");

        payments
                .peek(FraudDetectionApplication::printOnEnter)
                .filter((transactionId, order) -> !"".equals(transactionId))
                .filter((transactionId, order) -> order.getAmount() < 400)
                .mapValues(order -> {
                    order.setOrderId(order.getOrderId().toUpperCase());
                    return order;
                })
                .peek(FraudDetectionApplication::printOnExit)
                .to("validated-payments");

        Topology topology = streamsBuilder.build();

        KafkaStreams streams = new KafkaStreams(topology, props);

        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }

    private static void printOnEnter(String transactionId, Order order) {
        log.info("\n*********************************************************");
        log.info("Entering stream transaction {} for order {} with amount {}",
                transactionId, order.getOrderId(), order.getAmount());
    }

    private static void printOnExit(String transactionId, Order order) {
        log.info("Exiting stream transaction {} for order {} with amount {}",
                transactionId, order.getOrderId(), order.getAmount());
    }
}
