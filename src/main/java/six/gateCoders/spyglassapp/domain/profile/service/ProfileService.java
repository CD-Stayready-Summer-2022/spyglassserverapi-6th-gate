package six.gateCoders.spyglassapp.domain.profile.service;

import six.gateCoders.spyglassapp.domain.core.exceptions.ProfileNotFoundException;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> getAllProfiles();
    Profile getById(String id) throws ResourceNotFoundException;
    Profile create(Profile profile) throws ResourceCreationError;
    Profile update(String id, Profile profile) throws ResourceNotFoundException;
    void delete(String id) throws ProfileNotFoundException;







}
