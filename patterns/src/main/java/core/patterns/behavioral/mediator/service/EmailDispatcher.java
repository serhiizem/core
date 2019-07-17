package core.patterns.behavioral.mediator.service;

import core.patterns.behavioral.mediator.model.User;

public class EmailDispatcher implements MessageDispatcher {

    @Override
    public void send(User user, String message) {
        System.out.println(message + ", " + user.getName());
    }
}
