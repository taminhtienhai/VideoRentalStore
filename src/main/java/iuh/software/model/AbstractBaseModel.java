package iuh.software.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractBaseModel implements Persistable<UUID> {

    @Id
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Transient
    private boolean persisted = id != null;

    public AbstractBaseModel() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return !persisted;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @PostLoad
    @PostPersist
    private void setPersisted () {
        this.persisted = true;
    }
}
