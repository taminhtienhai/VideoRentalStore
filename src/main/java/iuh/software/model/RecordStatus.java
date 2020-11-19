package iuh.software.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity(name = "record_status")
public class RecordStatus extends AbstractBaseModel{

    private RecordType type;

    private Duration duration;

    private BigDecimal fee;

    private BigDecimal fine;

    @OneToMany(mappedBy = "recordStatus")
    private Set<Record> records;

    public enum RecordType {
        MOVIE,
        GAME
    }
}
