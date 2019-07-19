package core.patterns.behavioral.strategy.algorithms;

import core.patterns.behavioral.strategy.algorithms.RecordCreationStrategyFactory.RecordCreationType;

import java.util.Map;

public interface RecordCreationStrategy {
    void createRecord(Map<String, String> params);

    RecordCreationType getType();
}
