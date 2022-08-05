package six.gateCoders.spyglassapp.domain.profile.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import six.gateCoders.spyglassapp.domain.core.exceptions.ProfileNotFoundException;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.profile.dto.ProfileCreateRequest;
import six.gateCoders.spyglassapp.domain.profile.dto.ProfileDTO;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;
import six.gateCoders.spyglassapp.domain.profile.service.ProfileService;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> createProfile (@RequestBody ProfileCreateRequest profileDetail) throws ResourceNotFoundException{
        ProfileDTO profile = new ProfileDTO(profileService.create(profileDetail));
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Profile>> getAllProfiles(){
        Iterable<Profile> profiles = profileService.getAllProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Profile> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Profile profile = profileService.getById(id);
        return new ResponseEntity<>(profile,HttpStatus.OK);
    }

    //update
    @PostMapping("{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable("{id}") Long id, @RequestBody Profile profileDetail) throws ResourceNotFoundException{
        Profile profile = profileService.update(id, profileDetail);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProfile(@PathVariable("id") Long id) throws ResourceNotFoundException{
        profileService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
