package core.patterns.behavioral.observer;

import lombok.RequiredArgsConstructor;

import java.util.Deque;

@RequiredArgsConstructor
public class TwitterStream extends Observable {

    private final Deque<String> messageHistory;

    @Override
    public void setState(String message) {
        messageHistory.add(message);
        notifyObservers();
    }

    @Override
    public String getState() {
        return messageHistory.getLast();
    }
}
