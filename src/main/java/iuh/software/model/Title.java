package iuh.software.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Transient
    private Long type;

    @Transient
    private MultipartFile image;

    @Transient
    private int amount;

    @NonNull
    @OneToMany(
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
            mappedBy = "title")
    private List<DVD> dvds;

    @OneToMany(
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
            mappedBy = "title")
    private Set<ReserveDetail> reserveDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_status_id")
    private TitleStatus titleStatus;

    @PrePersist
    private void setUp() {
        dvds.forEach(dvd -> dvd.setTitle(this));
        // Add accosiat
        this.titleStatus.setId(type);
        dvds = IntStream.range(0, amount)
                .mapToObj(it -> new DVD())
                .collect(Collectors.toList());
    }
}
