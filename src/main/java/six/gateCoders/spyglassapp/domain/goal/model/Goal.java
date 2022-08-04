package six.gateCoders.spyglassapp.domain.goal.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Goal {
    @Id
    private Long id;

    @NonNull
    private String goalName;

    @NonNull
    private double targetDollarAmount;

    @NonNull
    private double currentDollarAmount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date targetDate;

    @NonNull
    private String description;

    private List<String> stepsForGoals;

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        creationDate = date;
        targetDate = date;
    }
}

