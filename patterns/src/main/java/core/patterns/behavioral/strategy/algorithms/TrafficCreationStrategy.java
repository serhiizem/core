package core.patterns.behavioral.strategy.algorithms;

import core.patterns.behavioral.strategy.algorithms.RecordCreationStrategyFactory.RecordCreationType;
import core.patterns.behavioral.strategy.model.TrafficRecord;
import core.patterns.behavioral.strategy.transport.traffic.TrafficRestService;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import static core.patterns.behavioral.strategy.algorithms.RecordCreationStrategyFactory.RecordCreationType.TRAFFIC;

@RequiredArgsConstructor
public class TrafficCreationStrategy implements RecordCreationStrategy {

    private final TrafficRestService trafficRestService;

    @Override
    public void createRecord(Map<String, String> params) {
        String period = params.get("period");
        String consumption = params.get("consumption");

        TrafficRecord trafficRecord = new TrafficRecord(period, consumption);

        trafficRestService.send(trafficRecord);
    }

    @Override
    public RecordCreationType getType() {
        return TRAFFIC;
    }
}
