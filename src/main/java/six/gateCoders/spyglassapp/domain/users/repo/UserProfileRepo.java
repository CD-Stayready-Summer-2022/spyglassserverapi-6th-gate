package six.gateCoders.spyglassapp.domain.users.repo;

import org.springframework.data.repository.CrudRepository;
import six.gateCoders.spyglassapp.domain.users.models.UserProfile;

import java.util.Optional;

public interface UserProfileRepo extends CrudRepository<UserProfile, String> {
    Optional<UserProfile> findByEmail(String email);
}
