package iuh.software.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractBaseModel implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private Long id;

    @Transient
    private boolean persisted = id != null;

    public AbstractBaseModel() {
    }

    @Override
    public Long getId() {
        return this.id;
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
