package fr.shortpath.back.repository;

import fr.shortpath.back.data.Producer;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProducerRepository extends ElasticsearchRepository<Producer, String> {

    @Query("{\"bool\" : {\"must\" : [{\"match\" : {\"login\" : \"?0\"}}]}}")
    Producer findByLogin(String login);

    // TODO find by nearest denomination
}
