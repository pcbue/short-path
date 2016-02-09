package fr.shortpath.frontal.api;

import java.util.List;
import java.util.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import fr.shortpath.back.data.Producer;
import fr.shortpath.back.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/producers")
public class ProducerResource {

    private ProducerService service;

    @Autowired
    public ProducerResource(ProducerService service) {
        this.service = service;
    }

    // TODO sl4j
    // TODO bean validation
    // TODO orika ?

    @GET
    @Produces("application/json")
    public List<Producer> getAllProducers() { // TODO paginated
        return null;
    }

    @GET
    @Path("/{login}")
    @Produces("application/json")
    public Producer getProducerByLogin(@PathParam("login") String login) {
        Optional<Producer> byLogin = service.findByLogin(login);         // TODO map to external object
        if (byLogin.isPresent()) {
            return byLogin.get();
        } else {
            return null;
        }
    }
}
