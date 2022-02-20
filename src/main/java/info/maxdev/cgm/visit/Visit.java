package info.maxdev.cgm.visit;

import info.maxdev.cgm.patient.Patient;
import info.maxdev.cgm.visitreason.VisitReason;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Visit extends PanacheEntity {
    @ManyToOne
    @NotNull
    private Patient patient;

    @NotNull
    public LocalDateTime date;

    @Lob
    public String anamnesis;

    @Enumerated(EnumType.STRING)
    @NotNull
    public VisitType type;

    @OneToOne
    @NotNull
    public VisitReason reason;

    public static List<Visit> findByPatient(Patient patient){
        return list("patient", Sort.by("date", Sort.Direction.Descending), patient);
    }

    @JsonbTransient
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
