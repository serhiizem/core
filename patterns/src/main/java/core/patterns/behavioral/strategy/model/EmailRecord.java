package core.patterns.behavioral.strategy.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EmailRecord {
    private final String email;
    private final String password;
    private final String accountType;
}
