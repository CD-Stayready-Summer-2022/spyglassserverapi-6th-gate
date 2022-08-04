package six.gateCoders.spyglassapp.domain.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
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
        return ProfileRepo.findAll();
    }

    @Override
    public Profile getById(Long id) throws ResourceNotFoundException {
        return ProfileRepo.findById(String.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("resource with Id not found"));
    }

    @Override
    public Profile create(Profile profile) throws ResourceCreationError {
        return ProfileRepo.save(profile);
    }

    @Override
    public Profile update(Long id, Profile profile) throws ResourceNotFoundException {
        Profile updateID = getById(id);
        updateID.setFirstName(profile.getFirstName());
        updateID.setLastName(profile.getLastName());
        updateID.setEmail(profile.getEmail());
        updateID.setPassword(profile.getPassword());
        return ProfileRepo.save(profile);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Profile profile = getById(id);
        ProfileRepo.delete(profile);
    }
}
