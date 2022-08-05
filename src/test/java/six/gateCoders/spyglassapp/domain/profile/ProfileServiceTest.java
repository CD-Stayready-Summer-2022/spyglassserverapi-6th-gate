package six.gateCoders.spyglassapp.domain.profile;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;
import six.gateCoders.spyglassapp.domain.profile.repo.ProfileRepo;
import six.gateCoders.spyglassapp.domain.profile.service.ProfileService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProfileServiceTest {
    @MockBean
    private ProfileRepo profileRepo;

    @Autowired
    private ProfileService profileService;

    private Profile mockProfile;

    private String id;


}
