package iuh.software.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "title")
public class Title extends AbstractBaseModel {

    @NonNull
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    private String description;

    @NonNull
    @OneToMany(
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
            mappedBy = "title")
    private Set<DVD> dvds;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "title")
    private Set<ReserveDetail> reserveDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_status_id")
    private TitleStatus titleStatus;

    @PostPersist
    private void setUp() {
        dvds.forEach(dvd -> dvd.setId(this.getId()));
    }
}
