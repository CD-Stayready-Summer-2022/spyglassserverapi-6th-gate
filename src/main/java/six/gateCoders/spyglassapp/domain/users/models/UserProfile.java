package six.gateCoders.spyglassapp.domain.users.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class UserProfile {
    @Id
    private String id;

    @NonNull
    private String email;

}
