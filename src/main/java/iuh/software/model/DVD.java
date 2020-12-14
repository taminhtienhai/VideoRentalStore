package iuh.software.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity(name = "dvd")
public class DVD extends AbstractBaseModel{

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @JsonIgnore
    @OneToMany(
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
            mappedBy = "dvd"
    )
    private Set<RentalDetail> rentalDetails;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id", nullable = false, referencedColumnName = "id")
    private Title title;

    @PrePersist
    public void setUp(){
        this.createDate = LocalDateTime.now();
    }
}
