package core.patterns.behavioral.observer;

import java.util.Deque;

public interface CountingDeque<T> extends Deque<T> {
    int getNumberOfQueues();
}
