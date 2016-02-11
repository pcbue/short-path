package fr.shortpath.application;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@SpringBootApplication(
    scanBasePackages = {"fr.shortpath.*"}
)
public class ShortpathApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ShortpathApplication.class);
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        return new ElasticsearchTemplate(
            NodeBuilder.nodeBuilder().client(true).node().client()
        );
    }

    public static void main(String... args) {
        new ShortpathApplication()
            .configure(new SpringApplicationBuilder(ShortpathApplication.class))
            .run(args);
    }
}
