package iuh.software.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "rental_info")
public class RentalInfo extends AbstractBaseModel {

<<<<<<< HEAD
	@Column(name = "rental_date")
	private LocalDateTime startDate;

	@Column(name = "return_date")
	private LocalDateTime returnDate;

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
=======
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
    private List<RentalDetail> rentalDetails;

    @PrePersist
    private void setUp() {
        rentalDetails.forEach(detail -> detail.setRentalInfo(this));
    }
>>>>>>> 1983e784d563a827652226747d9047fb5e7c132b
}
