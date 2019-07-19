package core.patterns.behavioral.strategy.algorithms;

import core.patterns.behavioral.strategy.algorithms.RecordCreationStrategyFactory.RecordCreationType;
import core.patterns.behavioral.strategy.model.EmailRecord;
import core.patterns.behavioral.strategy.transport.email.EmailsRestService;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import static core.patterns.behavioral.strategy.algorithms.RecordCreationStrategyFactory.RecordCreationType.EMAIL;

@RequiredArgsConstructor
public class EmailCreationStrategy implements RecordCreationStrategy {

    private final EmailsRestService emailsRestService;

    @Override
    public void createRecord(Map<String, String> params) {
        String email = params.get("email");
        String password = params.get("password");
        String accountType = params.get("accountType");

        EmailRecord emailRecord = new EmailRecord(email, password, accountType);

        emailsRestService.send(emailRecord);
    }

    @Override
    public RecordCreationType getType() {
        return EMAIL;
    }
}
