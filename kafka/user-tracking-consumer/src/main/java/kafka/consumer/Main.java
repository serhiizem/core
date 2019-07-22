package kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Properties;

import static java.util.Collections.singletonList;
import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Properties properties = new Properties();

        properties.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9093,localhost:9094");
        properties.put(GROUP_ID_CONFIG, "user-tracking-consumer");
        properties.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        Consumer<String, String> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(singletonList("user-tracking"));

        //noinspection InfiniteLoopStatement
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<String, String> record : records) {
                String key = record.key();
                String value = record.value();
                log.info("Consumed {}:{}", key, value);
            }
        }
    }
}
