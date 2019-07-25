package kafka.order_producer;

import kafka.common.model.Order;
import kafka.common.serde.OrderSerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Slf4j
public class OrderProducerApplication {

    public static void main(String[] args) throws InterruptedException {
        DataGenerator dataGenerator = new DataGenerator();

        Properties properties = new Properties();
        properties.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9093,localhost:9094");
        properties.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(VALUE_SERIALIZER_CLASS_CONFIG, OrderSerializer.class.getName());

        Producer<String, Order> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 10; i++) {
            String transactionId = dataGenerator.generateTransactionId();
            Order order = dataGenerator.generateOrder();

            ProducerRecord<String, Order> record = new ProducerRecord<>("payments", transactionId, order);
            log.info("Producing record to kafka: {}:{}", transactionId, order);
            producer.send(record);

            TimeUnit.SECONDS.sleep(1);
        }

        producer.close();
    }
}
