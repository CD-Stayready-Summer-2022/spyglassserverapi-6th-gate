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
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Profile.class)
    private List<Goal> Goals;


}
