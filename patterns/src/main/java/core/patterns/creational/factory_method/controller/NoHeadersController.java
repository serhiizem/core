package core.patterns.creational.factory_method.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class NoHeadersController {
    private final RestTemplate restTemplate;
}
