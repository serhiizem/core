package core.concurrency.race_condition;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LongWrapper {

    private long value;

    public void increment() {
        value = value + 1;
    }
}
