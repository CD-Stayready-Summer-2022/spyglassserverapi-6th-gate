package six.gateCoders.spyglassapp.domain.profile.model;


import lombok.*;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
public class Profile {
    @Id
    private String id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Goal> Goals;


}
