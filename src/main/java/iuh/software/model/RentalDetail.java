package iuh.software.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "rental_detail")
public class RentalDetail extends AbstractBaseModel {

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "rental_info_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private RentalInfo rentalInfo;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "dvd_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private DVD dvd;
  
}
