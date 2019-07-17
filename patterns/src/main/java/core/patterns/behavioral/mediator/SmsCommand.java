package core.patterns.behavioral.mediator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SmsCommand implements Command {

    private final UserNotificationMediator mediator;

    @Override
    public void send(String message) {
        mediator.sendSmsToUsers(message);
    }
}
