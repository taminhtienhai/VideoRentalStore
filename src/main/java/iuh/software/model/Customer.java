package iuh.software.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "customer")
public class Customer extends AbstractBaseModel {

    @NonNull
    private String name;

    @NonNull
    private String phone;

    private LocalDate birth;

    @Email
    private String email;

    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.REMOVE,
            mappedBy = "customer"
    )
    private Set<RentalInfo> rentalInfos;

    @JsonIgnore
    @OneToMany(
            mappedBy = "customer"
    )
    private Set<ReserveDetail> reserveDetails;
}
