package core.patterns.behavioral.mediator.service;

import core.patterns.behavioral.mediator.model.User;

public interface MessageDispatcher {
    void send(User user, String message);
}
