package six.gateCoders.spyglassapp.domain.goal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @NonNull
    private String steps;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    @JsonIgnore
    private Profile profile;

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        creationDate = date;
        targetDate = date;
    }
}

