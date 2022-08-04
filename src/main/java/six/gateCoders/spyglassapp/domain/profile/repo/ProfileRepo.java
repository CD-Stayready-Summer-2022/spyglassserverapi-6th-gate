package six.gateCoders.spyglassapp.domain.profile.repo;

import org.springframework.data.repository.CrudRepository;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;
import six.gateCoders.spyglassapp.domain.users.models.UserProfile;

import java.util.Optional;

public interface ProfileRepo extends CrudRepository<Profile, String> {
    Optional<Profile> findByEmail(String email);
}
