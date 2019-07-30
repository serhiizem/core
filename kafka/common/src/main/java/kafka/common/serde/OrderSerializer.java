package kafka.common.serde;

import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.common.model.Order;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class OrderSerializer implements Serializer<Order> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> map, boolean b) {
    }

    @Override
    @SneakyThrows
    public byte[] serialize(String s, Order order) {
        return MAPPER.writeValueAsBytes(order);
    }

    @Override
    public void close() {
    }
}
