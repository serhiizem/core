package core.generics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericsTestConfig {

    @Bean
    public Generics generics() {
        return new Generics();
    }
}
