package fr.shortpath.back.repository;

import fr.shortpath.back.ElasticsearchClientContext;
import fr.shortpath.back.SpringContext;
import fr.shortpath.back.data.Producer;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = {
        ElasticsearchClientContext.class,
        SpringContext.class
    }
)
public class ProducerRepositoryTest {

    @Autowired
    private ProducerRepository repository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Before
    public void setUp() throws Exception {
        elasticsearchTemplate.deleteIndex(Producer.class);
        elasticsearchTemplate.createIndex(Producer.class);
        elasticsearchTemplate.putMapping(Producer.class);
        elasticsearchTemplate.refresh(Producer.class, true);
    }

    @Test
    public void findByLoginWithMatchingOne() throws Exception {
        Producer p = new Producer();

        p.setLogin("zobzob");

        repository.index(p);

        Assertions.assertThat(repository.findByLogin("zobzob")).isNotNull();

        // TODO
    }
}