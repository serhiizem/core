package kafka.producer;

import com.github.javafaker.Faker;
import kafka.producer.enums.Color;
import kafka.producer.enums.DesignType;
import kafka.producer.enums.ProductType;
import kafka.producer.enums.UserId;
import kafka.producer.model.Event;
import kafka.producer.model.Product;
import kafka.producer.model.User;

public class EventGenerator {

    private Faker faker = new Faker();

    public Event generateEvent() {
        return Event.builder()
                .user(generateRandomUser())
                .product(generateRandomProduct())
                .build();
    }

    private User generateRandomUser() {
        return User.builder()
                .userId(faker.options().option(UserId.class))
                .username(faker.name().lastName())
                .dateOfBirth(faker.date().birthday())
                .build();
    }

    private Product generateRandomProduct() {
        return Product.builder()
                .color(faker.options().option(Color.class))
                .productType(faker.options().option(ProductType.class))
                .designType(faker.options().option(DesignType.class))
                .build();
    }
}
