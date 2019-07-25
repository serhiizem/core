package kafka.common.serde;

import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.common.model.Order;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class OrderDeserializer implements Deserializer<Order> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String DEFAULT_ENCODING = "UTF-8";

    @Override
    public void configure(Map<String, ?> map, boolean b) {
    }

    @Override
    @SneakyThrows
    public Order deserialize(String s, byte[] bytes) {
        return MAPPER.readValue(new String(bytes, DEFAULT_ENCODING), Order.class);
    }

    @Override
    public void close() {
    }
}
