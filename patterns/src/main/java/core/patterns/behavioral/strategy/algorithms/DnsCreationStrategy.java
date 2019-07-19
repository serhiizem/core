package core.patterns.behavioral.strategy.algorithms;

import core.patterns.behavioral.strategy.algorithms.RecordCreationStrategyFactory.RecordCreationType;
import core.patterns.behavioral.strategy.model.DnsRecord;
import core.patterns.behavioral.strategy.transport.dns.DnsRestService;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import static core.patterns.behavioral.strategy.algorithms.RecordCreationStrategyFactory.RecordCreationType.DNS;

@RequiredArgsConstructor
public class DnsCreationStrategy implements RecordCreationStrategy {

    private final DnsRestService dnsRestService;

    @Override
    public void createRecord(Map<String, String> params) {
        String host = params.get("host");
        String domain = params.get("domain");
        String subdomain = params.get("subdomain");

        DnsRecord dnsRecord = new DnsRecord(host, domain, subdomain);

        dnsRestService.send(dnsRecord);
    }

    @Override
    public RecordCreationType getType() {
        return DNS;
    }
}
