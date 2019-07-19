package core.patterns.behavioral.strategy.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TrafficRecord {
    private final String period;
    private final String consumption;
}
