package core.concurrency.race_condition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceConditionTest {

    private static final int NUMBER_OF_INCREMENTS = 1_000;
    private static final int NUMBER_OF_THREADS = 1_000;

    @Test
    void shouldProduceIncorrectCounterValueIfMultipleThreadsArePerformingUnsafeIncrement() {
        LongWrapper longWrapper = new LongWrapper(0L);

        Runnable incrementingTask = () -> {
            for (int i = 0; i < NUMBER_OF_INCREMENTS; i++) {
                longWrapper.increment();
            }
        };

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            new Thread(incrementingTask).start();
        }

        assertTrue(longWrapper.getValue() < NUMBER_OF_THREADS * NUMBER_OF_INCREMENTS);
    }
}