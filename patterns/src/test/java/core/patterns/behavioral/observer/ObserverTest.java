package core.patterns.behavioral.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObserverTest {

    private CountingDeque<String> deque = new DefaultCountingDequeue<>();

    @BeforeEach
    void init() {
        deque.clear();
    }

    @Test
    @DisplayName("Number of observer requests should be equal to the number of devices " +
            "multiplied by the number of messages entered on those devices")
    void shouldQueueCartesianProductOfTimes() {
        TwitterStream twitterStream = new TwitterStream(deque);

        PhoneDevice phoneDevice = new PhoneDevice(twitterStream);
        TabletDevice tabletDevice = new TabletDevice(twitterStream);

        phoneDevice.addMessage("Message1");
        tabletDevice.addMessage("Message2");
        tabletDevice.addMessage("Message3");
        phoneDevice.addMessage("Message4");

        int numberOfQueues = deque.getNumberOfQueues();
        assertEquals(8, numberOfQueues);
    }
}