package kafka.producer.model;

import kafka.producer.enums.Color;
import kafka.producer.enums.DesignType;
import kafka.producer.enums.ProductType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Color color;
    private ProductType productType;
    private DesignType designType;
}
