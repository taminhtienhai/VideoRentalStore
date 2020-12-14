package iuh.software.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "rental_info")
public class RentalInfo extends AbstractBaseModel {

    @Column(name = "rental_date")
    private LocalDateTime startDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "total_fee")
    private Long totalFee;

    @Column(name = "total_fine")
    private Long totalFine;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "rentalInfo")
    private List<RentalDetail> rentalDetails;

    @PrePersist
    private void setUp() {
        rentalDetails.forEach(detail -> detail.setRentalInfo(this));
        this.startDate = LocalDateTime.now();
    }
}
