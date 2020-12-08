package iuh.software.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.time.Duration;
import java.util.Set;

@Data
@Entity(name = "title_status")
public class TitleStatus extends AbstractBaseModel{

    @Enumerated
    private RecordType type;

    private Duration duration;

    private Long fee;

    private Long fine;

    @OneToMany(mappedBy = "titleStatus")
    private Set<Title> title;

    public enum RecordType {
        MOVIE,
        GAME
    }
}
