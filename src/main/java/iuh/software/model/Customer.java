package iuh.software.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Entity(name = "customer")
public class Customer extends AbstractBaseModel {

    @NonNull
    private String name;

    @NonNull
    private String phone;

    private LocalDate birth;

    private String email;

    @OneToMany(
            cascade = CascadeType.REMOVE,
            mappedBy = "customer"
    )
    private Set<RentalInfo> rentalInfos;

    @OneToMany(
            mappedBy = "customer"
    )
    private Set<ReserveDetail> reserveDetails;
}
