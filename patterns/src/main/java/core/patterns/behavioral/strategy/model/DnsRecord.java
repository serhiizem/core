package core.patterns.behavioral.strategy.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DnsRecord {
    private final String host;
    private final String domain;
    private final String subdomain;
}
