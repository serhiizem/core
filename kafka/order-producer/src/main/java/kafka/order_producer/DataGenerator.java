package kafka.order_producer;

import com.github.javafaker.Faker;
import kafka.common.model.Order;

public class DataGenerator {

    private Faker faker = new Faker();

    public String generateTransactionId() {
        return String.valueOf(faker.number().randomNumber(10, true));
    }

    public Order generateOrder() {
        Order order = new Order();

        order.setOrderId(faker.idNumber().toString());
        order.setUserId(faker.idNumber().toString());
        order.setAmount(faker.number().numberBetween(300, 600));

        return order;
    }
}
