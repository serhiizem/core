package kafka.producer;

import kafka.producer.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {
        EventGenerator eventGenerator = new EventGenerator();

        Properties properties = new Properties();
        properties.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9093,localhost:9094");
        properties.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        Producer<String, String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 10; i++) {
            log.info("Generating event #{}", i);

            Event event = eventGenerator.generateEvent();

            String key = extractKey(event);
            String value = extractValue(event);

            ProducerRecord<String, String> record = new ProducerRecord<>("user-tracking", key, value);
            log.info("Producing record to kafka: {}:{}", key, value);
            producer.send(record);

            TimeUnit.SECONDS.sleep(1);
        }

        producer.close();
    }

    private static String extractKey(Event event) {
        return event.getUser().getUserId().toString();
    }

    private static String extractValue(Event event) {
        return String.format("%s,%s,%s",
                event.getProduct().getProductType(),
                event.getProduct().getColor(),
                event.getProduct().getDesignType());
    }
}
