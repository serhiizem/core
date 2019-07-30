package kafka.streams.serde;

import kafka.common.model.Order;
import kafka.common.serde.OrderDeserializer;
import kafka.common.serde.OrderSerializer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class OrderSerde implements Serde<Order> {

    private Serializer<Order> serializer = new OrderSerializer();
    private Deserializer<Order> deserializer = new OrderDeserializer();

    @Override
    public void configure(Map<String, ?> map, boolean isKey) {
        serializer.configure(map, isKey);
        deserializer.configure(map, isKey);
    }

    @Override
    public Serializer<Order> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<Order> deserializer() {
        return deserializer;
    }

    @Override
    public void close() {
        serializer.close();
        deserializer.close();
    }
}
