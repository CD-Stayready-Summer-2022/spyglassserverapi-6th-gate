package six.gateCoders.spyglassapp.domain.goal.controller;

import lombok.Data;
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
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.goal.service.GoalService;

import java.util.ArrayList;
import java.util.List;

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
<<<<<<< HEAD
        //mockGoal = new Goal("TestGoal",1000.00,15.00,"TEST");
=======
        mockGoal = new Goal("TestGoal",1000.00,15.00,"TEST", "");
>>>>>>> ed3e3f049b368deff43cac7b2a76c30523434db4
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

    @Test
    @DisplayName("Goal goalCreate - /api/v1/goals/create : failed")
    public void createGoalRequestFailed() throws Exception {
        BDDMockito.doThrow(new ResourceCreationError("Exists")).when(goalService).create(any());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/vi/goals/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonConverter.asJsonString(mockGoal)))
                .andExpect(MockMvcResultMatchers.status().isConflict());
    }

    @Test
    @DisplayName("Goal Get All - /api/v1/goals : success")
    public void getAllGoalsSuccess() throws  Exception {
        List<Goal> goalList = new ArrayList<>();
        goalList.add(mockGoal);
        BDDMockito.doReturn(goalList).when(goalService).getall();
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/goals"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Goal Get by Id - /api/v1/goals/{id} : success")
    public void getByIdSuccess() throws Exception {
        BDDMockito.doReturn(mockGoal).when(goalService).getById(1L);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/goals/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1L)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.goalName", Is.is("TestGoal")));
    }

    @Test
    @DisplayName("Goal Get by Id - /api/v1/goals/{id} : Failed")
    public void getByIdFailed() throws Exception{
        BDDMockito.doThrow(new ResourceNotFoundException("Not found")).when(goalService).getById(1L);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/goals/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Get by Name - /api/v1/goals/findByName/{goalName} : success")
    public void getByNameSuccess() throws Exception {
        BDDMockito.doReturn(mockGoal).when(goalService).getByName("TestGoal");
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/goals/findByName/{goalName}", "TestGoal"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1L)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.goalName", Is.is("TestGoal")));
    }

    @Test
    @DisplayName("Get by Name - /api/v1/goals/findByName/{goalName} : Failed")
    public void getByNameFailed() throws Exception {
        BDDMockito.doThrow(new ResourceNotFoundException("Not found")).when(goalService).getByName("TestGoal");
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/goals/findByName/{goalName}", "TestGoal"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
