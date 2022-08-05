package six.gateCoders.spyglassapp.domain.profile.service;

import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.profile.dto.ProfileCreateRequest;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> getAllProfiles();
    Profile getById(Long id) throws ResourceNotFoundException;
    Profile create(ProfileCreateRequest detailDTO) throws ResourceCreationError;
    Profile update(Long id, Profile profile) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;







}
