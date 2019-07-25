package kafka.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
    private String orderId;
    private String userId;
    private int amount;
}
