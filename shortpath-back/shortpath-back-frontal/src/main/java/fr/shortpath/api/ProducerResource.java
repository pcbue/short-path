package fr.shortpath.api;

import java.util.List;
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

    @GET
    @Produces("application/json")
    public List<Producer> getAllProducers() { // TODO paginated
        return null;
    }

    @GET
    @Path("/{login}")
    @Produces("application/json")
    public Producer getProducerByLogin(@PathParam("login") String login) {
        return null;
    }
}
