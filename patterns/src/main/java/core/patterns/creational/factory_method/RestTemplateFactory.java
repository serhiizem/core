package core.patterns.creational.factory_method;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateFactory {
    RestTemplate createRestTemplate();
}
