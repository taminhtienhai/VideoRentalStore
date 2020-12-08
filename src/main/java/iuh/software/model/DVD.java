package iuh.software.model;

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

    @OneToMany(
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
            mappedBy = "dvd"
    )
    private Set<RentalDetail> rentalDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dvd_id", nullable = false)
    private Title title;

    @PostPersist
    public void setUp(){
        this.createDate = LocalDateTime.now();
    }
}
