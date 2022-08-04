package six.gateCoders.spyglassapp.domain.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;
import six.gateCoders.spyglassapp.domain.profile.repo.ProfileRepo;
import six.gateCoders.spyglassapp.domain.users.repo.UserProfileRepo;

import java.util.List;
@Service
public class profileServiceImpl implements ProfileService{
    private ProfileRepo ProfileRepo;
    @Autowired
    public profileServiceImpl(ProfileRepo ProfileRepo) {
        this.ProfileRepo = ProfileRepo;
    }
    @Override
    public List<Profile> getAllProfiles() {
        return null;
    }

    @Override
    public Profile getById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Profile create(Profile profile) throws ResourceCreationError {
        return null;
    }

    @Override
    public Profile Update(Long id, Profile profile) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void Delete(Long id) throws ResourceNotFoundException {

    }
}
