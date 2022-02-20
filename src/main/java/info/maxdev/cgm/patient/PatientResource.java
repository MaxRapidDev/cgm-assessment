package info.maxdev.cgm.patient;

import info.maxdev.cgm.visit.Visit;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

/**
 * The API for patients
 */
@Path("/api/v1/patients")
public class PatientResource {

    /**
     * List all patients
     *
     * @return the list of patients
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> list() {
        return Patient.listAll();
    }

    /**
     * Provides a specific Patient
     *
     * @param id the visit id
     * @return the patient object
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient get(@PathParam("id") Long id) {
        return Patient.findById(id);
    }

    /**
     * Provides all visits of a patient
     *
     * @param id the patient id
     * @return the list of visits
     */
    @GET
    @Path("/{id}/visits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Visit> getVisits(@PathParam("id") Long id) {
        return Visit.findByPatient(get(id));
    }

    /**
     * Persist a patient in the database
     *
     * @param patient the patient object
     * @return the persisted patient with the new id
     */
    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Patient createPatient(Patient patient) {
        patient.id = null;
        patient.persist();
        return patient;
    }
}