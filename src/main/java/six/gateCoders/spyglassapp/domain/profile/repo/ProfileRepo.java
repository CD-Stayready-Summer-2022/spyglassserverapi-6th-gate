package six.gateCoders.spyglassapp.domain.profile.repo;

import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;

import java.util.Optional;

public interface ProfileRepo {
    Optional<Profile> findByEmail(String email);
}
