package core.patterns.behavioral;

import core.patterns.behavioral.mediator.EmailCommand;
import core.patterns.behavioral.mediator.SmsCommand;
import core.patterns.behavioral.mediator.UserNotificationMediator;
import core.patterns.behavioral.mediator.model.User;
import core.patterns.behavioral.mediator.service.EmailDispatcher;
import core.patterns.behavioral.mediator.service.MessageDispatcher;
import core.patterns.behavioral.mediator.service.SmsDispatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MediatorTest.MediatorTestConfig.class)
class MediatorTest {

    @Autowired
    private UserNotificationMediator mediator;

    @Autowired
    private MessageDispatcher smsDispatcher;

    @Autowired
    private MessageDispatcher emailDispatcher;

    @Test
    void shouldSendSmsNotificationsToAllUsers() {
        User walter = new User("Walter");
        User peter = new User("Pater");

        mediator.registerUser(walter);
        mediator.registerUser(peter);

        SmsCommand smsCommand = new SmsCommand(mediator);
        smsCommand.send("Greetings");

        verify(smsDispatcher, times(2))
                .send(any(User.class), any(String.class));
        reset(smsDispatcher);
    }

    @Test
    void shouldSendEmailNotificationsToAllUsers() {
        User walter = new User("Walter");
        User peter = new User("Pater");

        mediator.registerUser(walter);
        mediator.registerUser(peter);

        EmailCommand emailCommand = new EmailCommand(mediator);
        emailCommand.send("Greetings");

        verify(emailDispatcher, times(2))
                .send(any(User.class), any(String.class));
        reset(emailDispatcher);
    }

    @Configuration
    static class MediatorTestConfig {

        @Bean
        @Scope(scopeName = "prototype")
        public UserNotificationMediator notificationMediator() {
            return new UserNotificationMediator(smsDispatcher(), emailDispatcher());
        }

        @Bean
        public MessageDispatcher smsDispatcher() {
            return mock(SmsDispatcher.class);
        }

        @Bean
        public MessageDispatcher emailDispatcher() {
            return mock(EmailDispatcher.class);
        }
    }
}
