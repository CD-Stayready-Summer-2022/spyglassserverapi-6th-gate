package six.gateCoders.spyglassapp.domain.profile.service;

import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> getAllProfiles();
    Profile getById(Long id) throws ResourceNotFoundException;
    Profile create(Profile profile) throws ResourceCreationError;
    Profile Update(Long id, Profile profile) throws ResourceNotFoundException;
    void Delete(Long id) throws ResourceNotFoundException;







}
