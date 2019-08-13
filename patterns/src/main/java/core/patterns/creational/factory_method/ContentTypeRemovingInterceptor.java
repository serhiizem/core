package core.patterns.creational.factory_method;

import lombok.SneakyThrows;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class ContentTypeRemovingInterceptor implements ClientHttpRequestInterceptor {

    private static final String CONTENT_TYPE = "Content-Type";

    @Override
    @SneakyThrows
    public ClientHttpResponse intercept(HttpRequest httpRequest,
                                        byte[] bytes,
                                        ClientHttpRequestExecution clientHttpRequestExecution) {
        httpRequest.getHeaders().remove(CONTENT_TYPE);
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
