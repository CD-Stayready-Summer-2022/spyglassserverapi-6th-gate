package six.gateCoders.spyglassapp.domain.profile;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import six.gateCoders.spyglassapp.domain.core.exceptions.ProfileNotFoundException;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
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
        mockProfile = new Profile("Yas","Wood","ywood001@gmail.com","password");
        mockProfile.setId("8e07da32-14c3-11ed-861d-0242ac120002");
    }

    @Test
    public void createProfileTest(){
        BDDMockito.doReturn(Optional.empty()).when(profileRepo).findById(ArgumentMatchers.any());
        BDDMockito.doReturn(mockProfile).when(profileRepo).save(mockProfile);
        Profile profile = profileService.create(mockProfile);
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
        Profile updatedProfile = new Profile("Omar","Carey","oac001@gmail.com","password01");
        profileService.update(mockProfile.getId(),updatedProfile);
        String expected = String.format("%s,%s,%s,%s",updatedProfile.getFirstName(),updatedProfile.getLastName(),updatedProfile.getEmail(),updatedProfile.getPassword());
        String actual = String.format("%s,%s,%s,%s",mockProfile.getFirstName(),mockProfile.getLastName(),mockProfile.getEmail(),mockProfile.getPassword());
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
