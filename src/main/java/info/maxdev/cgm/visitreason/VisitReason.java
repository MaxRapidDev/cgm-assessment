package info.maxdev.cgm.visitreason;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class VisitReason extends PanacheEntity {
    @Column(unique=true)
    @NotNull
    public String domainId;
}
