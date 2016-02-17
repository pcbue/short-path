package fr.shortpath.back;

import fr.shortpath.back.repository.ProducerRepository;
import fr.shortpath.back.service.ProducerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("fr.shortpath.back.repository")
public class SpringContext {

    @Bean
    public ProducerService producerService(ProducerRepository repository) {
        return new ProducerService(repository);
    }
}
