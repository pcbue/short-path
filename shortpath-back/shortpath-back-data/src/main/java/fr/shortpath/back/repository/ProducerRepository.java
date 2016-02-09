package fr.shortpath.back.repository;

import fr.shortpath.back.data.Producer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProducerRepository extends ElasticsearchRepository<Producer, String> {

    Producer findByLogin(String login);
}
