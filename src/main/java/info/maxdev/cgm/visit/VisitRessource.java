package info.maxdev.cgm.visit;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The API for visits
 */
@Path("/api/v1/visits")
public class VisitRessource {
    /**
     * Provides a specific Visit
     *
     * @param id the visit id
     * @return the visit object
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Visit get(@PathParam("id") Long id) {
        return Visit.findById(id);
    }

    /**
     * Persist a visit in the database
     *
     * @param visit the visit object
     * @return the persisted visit object with the new id
     */
    @POST
    @Transactional
    public Response create(Visit visit) {
        visit.id = null;
        visit.persist();
        return Response.status(Response.Status.CREATED).entity(visit).build();
    }

    /**
     * Updates a visit object in the database
     *
     * @param visit the visit object
     * @return the persisted visit object with the new id
     */
    @PUT
    @Transactional
    public Visit update(Visit visit) {
        Visit entity = Visit.findById(visit.id);
        if (entity == null) {
            throw new NotFoundException();
        }

        entity.anamnesis = visit.anamnesis;
        entity.date = visit.date;
        entity.reason = visit.reason;
        entity.type = visit.type;

        return entity;
    }

    /**
     * Deletes a visit in the database
     *
     * @param id the visit id
     */
    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Visit.deleteById(id);
    }
}