package six.gateCoders.spyglassapp.domain.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import six.gateCoders.spyglassapp.domain.core.exceptions.ProfileNotFoundException;
import six.gateCoders.spyglassapp.domain.profile.dto.ProfileCreateRequest;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;
import six.gateCoders.spyglassapp.domain.profile.repo.ProfileRepo;
import six.gateCoders.spyglassapp.domain.profile.service.ProfileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProfileServiceTest {
    @MockBean
    private ProfileRepo profileRepo;

    @Autowired
    private ProfileService profileService;

    private Profile mockProfile;

    private String expectedId;


    @BeforeEach
    public void setUp(){
        expectedId = "8e07da32-14c3-11ed-861d-0242ac120002";
        mockProfile = new Profile("Yas","Wood","ywood001@gmail.com");
        mockProfile.setId("8e07da32-14c3-11ed-861d-0242ac120002");
    }

    @Test
    public void createProfileTest(){
        BDDMockito.doReturn(Optional.empty()).when(profileRepo).findById(ArgumentMatchers.any());
        BDDMockito.doReturn(mockProfile).when(profileRepo).save(mockProfile);
        ProfileCreateRequest request = new ProfileCreateRequest();
        request.setEmail(mockProfile.getEmail());
        request.setFirstName(mockProfile.getFirstName());
        request.setLastName(mockProfile.getLastName());
        request.setPassword("password");
        Profile profile = profileService.create(request);
        Assertions.assertEquals(expectedId, profile.getId());
    }

    @Test
    public void getByIdTest(){
        BDDMockito.doReturn(Optional.of(mockProfile)).when(profileRepo).findById(any());
        Profile profile = profileService.getById(expectedId);
        Assertions.assertEquals(expectedId, profile.getId());
    }

    @Test
    public void getAllProfiles(){
        List<Profile> userProfiles = new ArrayList<>();
        userProfiles.add(mockProfile);
        BDDMockito.doReturn(userProfiles).when(profileRepo).findAll();
        List<Profile> actual = profileService.getAllProfiles();
        Integer expectedSize = 1;
        Integer actualSize = actual.size();
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void updateTest(){
        BDDMockito.doReturn(Optional.of(mockProfile)).when(profileRepo).findById(any());
        Profile updatedProfile = new Profile("Omar","Carey","oac001@gmail.com");
        profileService.update(mockProfile.getId(),updatedProfile);
        String expected = String.format("%s,%s,%s",updatedProfile.getFirstName(),updatedProfile.getLastName(),updatedProfile.getEmail());
        String actual = String.format("%s,%s,%s",mockProfile.getFirstName(),mockProfile.getLastName(),mockProfile.getEmail(),mockProfile);
        Assertions.assertEquals(expected,actual);
    }


    @Test
    @DisplayName("delete")
    public void deleteTest01() throws ProfileNotFoundException {
        BDDMockito.doReturn(Optional.empty()).when(profileRepo).findById(any());
        Assertions.assertThrows(ProfileNotFoundException.class, ()->{
            profileService.delete("8e07da32-14c3-11ed-861d-0242ac120002");
        });


    }






}
