package fr.shortpath.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication(
    scanBasePackages = {"fr.shortpath.*"}
)
public class ShortpathApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ShortpathApplication.class);
    }

    public static void main(String... args) {
        new ShortpathApplication()
            .configure(new SpringApplicationBuilder(ShortpathApplication.class))
            .run(args);
    }
}
