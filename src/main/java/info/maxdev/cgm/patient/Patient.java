package info.maxdev.cgm.patient;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Patient extends PanacheEntity {
    public String name;

    @NotNull
    @Column(length = 1024)
    public String imageurl;

    @NotNull
    public String surname;

    @NotNull
    public LocalDate dateOfBirth;

    @NotNull
    @Column(unique=true)
    public String socialSecurityNumber;
}
