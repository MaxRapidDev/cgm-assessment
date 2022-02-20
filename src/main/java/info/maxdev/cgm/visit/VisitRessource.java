package info.maxdev.cgm.visit;

import info.maxdev.cgm.patient.Patient;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1/visits")
public class VisitRessource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> list() {
        return Visit.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Visit get(@PathParam("id") Long id) {
        return Visit.findById(id);
    }

    @POST
    @Transactional
    public Visit create(Visit visit) {
        visit.persist();
        return visit;
    }

    @PUT
    @Transactional
    public Visit update(Visit visit) {
        Visit entity = Visit.findById(visit.id);
        if(entity == null) {
            throw new NotFoundException();
        }

        entity.anamnesis = visit.anamnesis;
        entity.date = visit.date;
        entity.reason = visit.reason;
        entity.type = visit.type;

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Visit.deleteById(id);
    }
}