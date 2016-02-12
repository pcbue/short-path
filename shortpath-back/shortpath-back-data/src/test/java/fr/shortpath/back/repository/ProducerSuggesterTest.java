package fr.shortpath.back.repository;

import fr.shortpath.back.ElasticsearchClientContext;
import fr.shortpath.back.SpringContext;
import fr.shortpath.back.data.Producer;
import org.elasticsearch.common.collect.FluentIterable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = {
        ElasticsearchClientContext.class,
        SpringContext.class
    }
)
public class ProducerSuggesterTest {

    @Autowired
    private ProducerSuggester producerSuggester;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Before
    public void setUp() throws Exception {
        elasticsearchTemplate.deleteIndex(Producer.class);
        elasticsearchTemplate.createIndex(Producer.class);
        elasticsearchTemplate.putMapping(Producer.class);
        elasticsearchTemplate.refresh(Producer.class, true);
    }

    private void index(Producer... producers) {
        elasticsearchTemplate.bulkIndex(
            FluentIterable.of(producers).transform(
                producer -> new IndexQueryBuilder()
                    .withId(producer.getLogin())
                    .withObject(producer)
                    .build()
            ).toList()
        );
        elasticsearchTemplate.refresh(Producer.class, true);
    }

    private Producer producer(String login, String firstName, String lastName) {
        Producer producer = new Producer();
        producer.setLogin(login);
        producer.setFirstName(firstName);
        producer.setLastName(lastName);
        return producer;
    }

    @Test
    public void suggest() throws Exception {
        index(producer("mtoto", "maurice", "toto"), producer("mtota", "marcel", "tota"), producer("rtiti", "richard", "titi"));

        producerSuggester.suggestByFirstName("mauri");
    }
}