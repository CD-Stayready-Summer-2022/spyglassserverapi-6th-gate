package six.gateCoders.spyglassapp.domain.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import six.gateCoders.spyglassapp.domain.core.exceptions.ProfileNotFoundException;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;
import six.gateCoders.spyglassapp.domain.profile.repo.ProfileRepo;

import java.util.List;
@Service
public class ProfileServiceImpl implements ProfileService{
    private ProfileRepo profileRepo;
    @Autowired
    public ProfileServiceImpl(ProfileRepo ProfileRepo) {
        this.profileRepo = ProfileRepo;
    }
    @Override
    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }

    @Override
    public Profile getById(String id) throws ResourceNotFoundException {
        return profileRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("resource with Id not found"));
    }

    @Override
    public Profile create(Profile profile) throws ResourceCreationError {
        return profileRepo.save(profile);
    }

    @Override
    public Profile update(String id, Profile profile) throws ResourceNotFoundException {
        Profile updateID = getById(id);
        updateID.setFirstName(profile.getFirstName());
        updateID.setLastName(profile.getLastName());
        updateID.setEmail(profile.getEmail());
        updateID.setPassword(profile.getPassword());
        return profileRepo.save(profile);
    }

    @Override
    public void delete(String id) throws ProfileNotFoundException {
        profileRepo.findById(id)
                .orElseThrow(()-> new ProfileNotFoundException("No User Profile with id: "+ id));
        Profile userProfile = getById(id);
        profileRepo.delete(userProfile);
    }
}
