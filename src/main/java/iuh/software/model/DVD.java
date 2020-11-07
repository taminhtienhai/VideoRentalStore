package iuh.software.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Entity(name = "dvd")
public class DVD extends AbstractBaseModel{

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Enumerated
    private DVDStatus status;

    @OneToMany(
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
            mappedBy = "dvd"
    )
    private Set<RentalDetail> rentalDetails;

    @NonNull
    @OneToMany(
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
            mappedBy = "dvd"
    )
    private Set<Record> records;

    public enum DVDStatus {
        RENTED,
        AVAILABLE
    }
}
