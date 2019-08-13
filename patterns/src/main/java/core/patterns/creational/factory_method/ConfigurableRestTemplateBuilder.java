package core.patterns.creational.factory_method;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class ConfigurableRestTemplateBuilder implements RestTemplateFactory {

    private final RestTemplateBuilder restTemplateBuilder;

    @Override
    public RestTemplate createRestTemplate() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.getInterceptors().add(new ContentTypeRemovingInterceptor());
        return restTemplate;
    }
}
