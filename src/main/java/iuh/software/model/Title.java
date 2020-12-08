package iuh.software.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor
@Data
@Entity(name = "title")
public class Title extends AbstractBaseModel {

    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    private String description;

    @Transient
    private Long type;

    @Transient
    private int amount;

    @JsonIgnore
    @OneToMany(
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
            mappedBy = "title")
    private List<DVD> dvds;

    @JsonIgnore
    @OneToMany(
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
            mappedBy = "title")
    private Set<ReserveDetail> reserveDetails;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_status_id")
    private TitleStatus titleStatus = new TitleStatus();

    @PrePersist
    private void setUp() {
        // Add accosiat
        this.titleStatus.setId(type);
        dvds = IntStream.range(0, amount)
                .mapToObj(it -> new DVD())
                .peek(dvd -> dvd.setTitle(this))
                .collect(Collectors.toList());
    }
}
