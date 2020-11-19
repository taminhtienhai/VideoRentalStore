package iuh.software.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "record")
public class Record extends AbstractBaseModel {

    @NonNull
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dvd_id")
    private DVD dvd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_status_id")
    private RecordStatus recordStatus;

    @OneToMany(mappedBy = "record")
    private Set<ReserveDetail> reserveDetails;
}
