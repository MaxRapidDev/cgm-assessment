package info.maxdev.cgm.patient;

import info.maxdev.cgm.visit.Visit;

import java.util.List;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/api/v1/patients")
public class PatientResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> list() {
        return Patient.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient get(@PathParam("id") Long id) {
        return Patient.findById(id);
    }

    @GET
    @Path("/{id}/visits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Visit> getVisits(@PathParam("id") Long id) {
        return Visit.findByPatient(get(id));
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPatient(Patient patient) {
        patient.id = null;
        patient.persist();
        return Response.status(Status.CREATED).entity(patient).build();
    }
}