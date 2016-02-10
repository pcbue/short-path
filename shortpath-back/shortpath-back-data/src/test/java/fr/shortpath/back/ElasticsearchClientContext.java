package fr.shortpath.back;

import java.nio.file.Paths;
import java.util.UUID;

import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = {"fr.shortpath.back.repository"})
public class ElasticsearchClientContext {

    @Value("#{systemProperties['buildDirectory'] ?: 'target'}")
    private String buildDirectory;

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        return new ElasticsearchTemplate(
            NodeBuilder.nodeBuilder().local(true).settings(
                ImmutableSettings.settingsBuilder()
                    .put("path.data", Paths.get(buildDirectory, String.format("es-data-%s", UUID.randomUUID().toString())))
                    .put("http.enabled", false)
            ).node().client()
        );
    }
}
