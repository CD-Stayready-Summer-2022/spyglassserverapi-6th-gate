package six.gateCoders.spyglassapp.domain.profile.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import six.gateCoders.spyglassapp.domain.core.exceptions.ProfileNotFoundException;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.profile.dto.ProfileCreateRequest;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;
import six.gateCoders.spyglassapp.domain.profile.repo.ProfileRepo;
import six.gateCoders.spyglassapp.security.services.FirebaseUserMgrService;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;
import six.gateCoders.spyglassapp.domain.profile.repo.ProfileRepo;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepo profileRepo;
    private FirebaseUserMgrService firebaseUserMgrService;


    @Autowired
    public ProfileServiceImpl(ProfileRepo ProfileRepo, FirebaseUserMgrService firebaseUserMgrService) {
        this.profileRepo = ProfileRepo;
        this.firebaseUserMgrService = firebaseUserMgrService;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }

    @Override
    public Profile getById(String id) throws ResourceNotFoundException {
        return profileRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource with Id not found"));
    }

    @Override
    public Profile create(ProfileCreateRequest detailDTO) throws ResourceCreationError {
        Optional<Profile> optional = profileRepo.findByEmail(detailDTO.getEmail());
        if (optional.isPresent()) {
            throw new ResourceCreationError("Profile with this email exist");
        }
        log.info(detailDTO.toString());
        String uuid = firebaseUserMgrService.createFireBaseUser(detailDTO);
        Profile profile = new Profile(detailDTO.getFirstName(), detailDTO.getLastName(), detailDTO.getEmail());
        profile.setId(uuid);
        return profileRepo.save(profile);
    }

    @Override
    public Profile addGoalToProfile(Goal goal, String profileId) throws ResourceNotFoundException {
        Profile profile = getById(profileId);
        goal.setProfile(profile);
        profile.getGoals().add(goal);
        return profileRepo.save(profile);
    }



    @Override
    public Profile update (String id, Profile profile) throws ResourceNotFoundException {
        Profile updateID = getById(id);
        updateID.setFirstName(profile.getFirstName());
        updateID.setLastName(profile.getLastName());
        updateID.setEmail(profile.getEmail());
        return profileRepo.save(profile);
    }


    @Override
    public void delete (String id) throws ProfileNotFoundException {
        profileRepo.findById(id).orElseThrow(() -> new ProfileNotFoundException("No User Profile with id: " + id));
        Profile userProfile = getById(id);
        profileRepo.delete(userProfile);
    }
}


