package iuh.software.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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