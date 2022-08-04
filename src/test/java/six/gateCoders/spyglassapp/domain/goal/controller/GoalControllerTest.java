package six.gateCoders.spyglassapp.domain.goal.controller;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import six.gateCoders.spyglassapp.domain.JsonConverter;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.goal.service.GoalService;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GoalControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private GoalService goalService;

    private Goal mockGoal;

    @BeforeEach
    public void setUp(){
        mockGoal = new Goal("TestGoal",1000.00,15.00,"TEST");
        mockGoal.setId(1L);
        mockMvc = MockMvcBuilders
                .standaloneSetup(new GoalController(goalService))
                .build();
    }

    @Test
    @DisplayName("Goal goalCreate - /api/vi/goals/create : success")
    public void createGoalRequestSuccess() throws Exception{
        BDDMockito.doReturn(mockGoal).when(goalService).create(any());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/vi/goals/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonConverter.asJsonString(mockGoal)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1L)));
    }

}
