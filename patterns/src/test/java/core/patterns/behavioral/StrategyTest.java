package core.patterns.behavioral;

import core.patterns.behavioral.strategy.algorithms.*;
import core.patterns.behavioral.strategy.transport.dns.DnsRestService;
import core.patterns.behavioral.strategy.transport.dns.DnsRestServiceImpl;
import core.patterns.behavioral.strategy.transport.email.EmailsRestService;
import core.patterns.behavioral.strategy.transport.email.EmailsRestServiceImpl;
import core.patterns.behavioral.strategy.transport.traffic.TrafficRestService;
import core.patterns.behavioral.strategy.transport.traffic.TrafficRestServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.List;

import static core.patterns.behavioral.strategy.algorithms.RecordCreationStrategyFactory.RecordCreationType.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = StrategyTest.StrategyTestConfiguration.class)
@ExtendWith(SpringExtension.class)
class StrategyTest {

    //@formatter:off
    @Autowired private RecordCreationStrategyFactory recordCreationStrategyFactory;
    @Autowired private DnsRestService dnsRestService;
    @Autowired private EmailsRestService emailsRestService;
    @Autowired private TrafficRestService trafficRestService;
    //@formatter:on

    @BeforeEach
    void init() {
        reset(dnsRestService, emailsRestService, trafficRestService);
    }

    @Test
    void shouldUseDnsRestServiceIfDnsCreationStrategyIsUsed() {
        RecordCreationStrategy recordCreationStrategy = recordCreationStrategyFactory.get(DNS);

        HashMap<String, String> params = new HashMap<>();
        params.put("host", "10.350.24.21");
        params.put("domain", "test");
        params.put("subdomain", "subtest");

        recordCreationStrategy.createRecord(params);

        verify(dnsRestService, times(1)).send(any());
        verify(emailsRestService, times(0)).send(any());
        verify(trafficRestService, times(0)).send(any());
    }

    @Test
    void shouldUseEmailsRestServiceIfEmailsCreationStrategyIsUsed() {
        RecordCreationStrategy recordCreationStrategy = recordCreationStrategyFactory.get(EMAIL);

        HashMap<String, String> params = new HashMap<>();
        params.put("email", "test@gmail.com");
        params.put("password", "^$hgjwwh^&#^dngksdhl^&#$^!T))#");
        params.put("accountType", "regular");

        recordCreationStrategy.createRecord(params);

        verify(dnsRestService, times(0)).send(any());
        verify(emailsRestService, times(1)).send(any());
        verify(trafficRestService, times(0)).send(any());
    }

    @Test
    void shouldUseTrafficRestServiceIfTrafficCreationStrategyIsUsed() {
        RecordCreationStrategy recordCreationStrategy = recordCreationStrategyFactory.get(TRAFFIC);

        HashMap<String, String> params = new HashMap<>();
        params.put("period", "10.02.19-25.04.19");
        params.put("consumption", "600TB");

        recordCreationStrategy.createRecord(params);


        verify(dnsRestService, times(0)).send(any());
        verify(emailsRestService, times(0)).send(any());
        verify(trafficRestService, times(1)).send(any());
    }

    @Configuration
    static class StrategyTestConfiguration {

        @Bean
        public RecordCreationStrategy emailCreationStrategy() {
            return new EmailCreationStrategy(emailRestService());
        }

        @Bean
        public RecordCreationStrategy trafficCreationStrategy() {
            return new TrafficCreationStrategy(trafficRestService());
        }

        @Bean
        public RecordCreationStrategy dnsCreationStrategy() {
            return new DnsCreationStrategy(dnsRestService());
        }

        @Bean
        public TrafficRestService trafficRestService() {
            return mock(TrafficRestServiceImpl.class);
        }

        @Bean
        public DnsRestService dnsRestService() {
            return mock(DnsRestServiceImpl.class);
        }

        @Bean
        public EmailsRestService emailRestService() {
            return mock(EmailsRestServiceImpl.class);
        }

        @Bean
        public RecordCreationStrategyFactory recordCreationStrategyFactory(List<RecordCreationStrategy> strategies) {
            return new RecordCreationStrategyFactory(strategies);
        }
    }
}
