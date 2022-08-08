package six.gateCoders.spyglassapp.domain.profile;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import six.gateCoders.spyglassapp.domain.JsonConverter;
import six.gateCoders.spyglassapp.domain.core.exceptions.ProfileNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.controller.GoalController;
import six.gateCoders.spyglassapp.domain.profile.controller.ProfileController;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;
import six.gateCoders.spyglassapp.domain.profile.service.ProfileService;
import six.gateCoders.spyglassapp.security.models.FireBaseUser;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerTest {

    private MockMvc mockMvc;
    @MockBean
    private ProfileService profileService;

    private Profile mockProfile;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders
                .standaloneSetup(new ProfileController(profileService))
                .build();
        String expectedId = "8e07da32-14c3-11ed-861d-0242ac120002";
        mockProfile = new Profile("Yas","Wood","ywood001@gmail.com","password");
        mockProfile.setId("8e07da32-14c3-11ed-861d-0242ac120002");
    }


    @Test
    public void createProfileSuccess() throws Exception {
        BDDMockito.doReturn(mockProfile).when(profileService).create(any());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/profile/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonConverter.asJsonString(mockProfile)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is("8e07da32-14c3-11ed-861d-0242ac120002")));
    }
}


