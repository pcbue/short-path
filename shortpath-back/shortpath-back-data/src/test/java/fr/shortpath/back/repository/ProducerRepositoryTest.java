package fr.shortpath.back.repository;

import fr.shortpath.back.SpringContext;
import fr.shortpath.back.data.Producer;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.node.NodeBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = {
        ProducerRepositoryTest.Context.class,
        SpringContext.class
    }
)
public class ProducerRepositoryTest {

    @Configuration
    @EnableElasticsearchRepositories(basePackages = {"fr.shortpath.back.repository"})
    public static class Context {

        @Bean
        public ElasticsearchTemplate elasticsearchTemplate() {
            return new ElasticsearchTemplate(
                NodeBuilder.nodeBuilder().local(true).settings(
                    ImmutableSettings.settingsBuilder()
                        .put("path.data", "target/es-data")
                        .put("http.enabled", false)
                ).node().client()
            );
        }
    }

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

        repository.findByLogin("zobzob");

        // TODO
    }
}