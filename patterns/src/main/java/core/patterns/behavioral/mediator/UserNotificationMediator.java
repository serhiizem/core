package core.patterns.behavioral.mediator;

import core.patterns.behavioral.mediator.model.User;
import core.patterns.behavioral.mediator.service.MessageDispatcher;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UserNotificationMediator {

    private List<User> users = new ArrayList<>();

    private final MessageDispatcher smsDispatcher;
    private final MessageDispatcher emailDispatcher;

    public void registerUser(User user) {
        users.add(user);
    }

    void sendSmsToUsers(String message) {
        for (User user : users) {
            smsDispatcher.send(user, message);
        }
    }

    void sendEmailToUsers(String message) {
        for (User user : users) {
            emailDispatcher.send(user, message);
        }
    }
}
