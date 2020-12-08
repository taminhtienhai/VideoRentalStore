package iuh.software.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "rental_info")
public class RentalInfo extends AbstractBaseModel {

    @Column(name = "rental_date")
    private LocalDateTime startDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            updatable = false
    )
    private Customer customer;

    @OneToMany(
            cascade = CascadeType.PERSIST,
            mappedBy = "rentalInfo"
    )
    private Set<RentalDetail> rentalDetails;
}
