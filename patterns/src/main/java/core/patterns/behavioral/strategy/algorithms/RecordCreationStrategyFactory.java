package core.patterns.behavioral.strategy.algorithms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RecordCreationStrategyFactory {

    private Map<RecordCreationType, RecordCreationStrategy> strategiesMap = new HashMap<>();

    @Autowired
    public RecordCreationStrategyFactory(List<RecordCreationStrategy> strategies) {
        strategies.forEach(s -> strategiesMap.put(s.getType(), s));
    }

    public RecordCreationStrategy get(RecordCreationType type) {
        return strategiesMap.get(type);
    }

    public enum RecordCreationType {
        EMAIL,
        TRAFFIC,
        DNS
    }
}
