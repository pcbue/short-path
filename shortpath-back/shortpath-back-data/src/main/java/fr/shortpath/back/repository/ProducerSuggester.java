package fr.shortpath.back.repository;

import fr.shortpath.back.data.Producer;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

public class ProducerSuggester {

    private ElasticsearchTemplate elasticsearchTemplate;

    public ProducerSuggester(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public void suggestByFirstName(String firstName) {
        // TODO return results
        // TODO suggest earlier

        elasticsearchTemplate.suggest(
            SuggestBuilders.termSuggestion("term").field("firstName").text(firstName),
            Producer.class
        );
    }
}
