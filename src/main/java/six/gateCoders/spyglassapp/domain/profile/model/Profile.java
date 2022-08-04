package six.gateCoders.spyglassapp.domain.profile.model;


import lombok.*;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @NonNull
    private String password;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Profile.class)
    private List<Goal> Goals;


}
