package info.maxdev.cgm.visitreason;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * The API for visit reasons
 */
@Path("/api/v1/visitreasons")
public class VisitReasonResource {

    /**
     * List all visit reasons
     *
     * @return the list of visit reason
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VisitReason> list() {
        return VisitReason.listAll();
    }
}