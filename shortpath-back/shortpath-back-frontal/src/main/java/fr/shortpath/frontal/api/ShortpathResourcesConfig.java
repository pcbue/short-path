package fr.shortpath.frontal.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@ApplicationPath("shortpath")
@Component
public class ShortpathResourcesConfig extends ResourceConfig {

    public ShortpathResourcesConfig() {
        packages(false, ShortpathResourcesConfig.class.getPackage().getName());
    }
}
