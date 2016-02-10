package fr.shortpath.back;

import fr.shortpath.back.repository.ProducerRepository;
import fr.shortpath.back.service.ProducerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContext {

    @Bean
    public ProducerService producerService(ProducerRepository repository) {
        return new ProducerService(repository);
    }
}
