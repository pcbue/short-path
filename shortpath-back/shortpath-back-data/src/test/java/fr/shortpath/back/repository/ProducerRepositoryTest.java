package fr.shortpath.back.repository;

import fr.shortpath.back.ElasticsearchClientContext;
import fr.shortpath.back.SpringContext;
import fr.shortpath.back.data.Producer;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    private void index(Producer... producer) {
        repository.save(Lists.newArrayList(producer));
    }

    private Producer producer(String login) {
        Producer producer = new Producer();
        producer.setLogin(login);
        return producer;
    }

    @Test
    public void findByLoginWithMatchingOne() throws Exception {
        index(producer("zobzob"));

        Assertions.assertThat(
            repository.findByLogin("zobzob")
        )
            .isNotNull()
            .extracting("login")
            .containsOnly("zobzob");
    }

    @Test
    public void findByLoginWithNonMatchingOne() throws Exception {
        index(producer("zobzob"));

        Assertions.assertThat(
            repository.findByLogin("zibzib")
        )
            .isNull();
    }

    @Test
    public void findAllTakeCareOfPage() throws Exception {
        index(producer("zobzob"), producer("zibzib"));

        Assertions.assertThat(
            repository.findAll(new PageRequest(0, 3))
        )
            .hasSize(2)
            .extracting("login")
            .containsOnly("zobzob", "zibzib");
    }

    @Test
    public void findAllTakeCareOfPageWithSize() throws Exception {
        index(producer("zobzob"), producer("zibzib"));

        Assertions.assertThat(
            repository.findAll(new PageRequest(1, 1))
        )
            .hasSize(1)
            .extracting("login")
            .containsOnly("zibzib");
    }
}