package info.maxdev.cgm.visitreason;

import info.maxdev.cgm.visit.Visit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1/visitreasons")
public class VisitReasonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VisitReason> list() {
        return VisitReason.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Visit get(@PathParam("id") Long id) {
        return VisitReason.findById(id);
    }

}