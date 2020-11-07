package iuh.software.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Entity(name = "rental_detail")
public class RentalDetail extends AbstractBaseModel {

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "rental_info_id",
            updatable = false
    )
    private RentalInfo rentalInfo;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "dvd_id",
            updatable = false
    )
    private DVD dvd;
}
