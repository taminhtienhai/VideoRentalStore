package iuh.software.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
