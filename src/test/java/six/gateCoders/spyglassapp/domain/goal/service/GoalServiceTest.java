package six.gateCoders.spyglassapp.domain.goal.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.goal.repo.GoalRepo;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GoalServiceTest {

    @MockBean
    private GoalRepo goalRepo;

    @Autowired
    private GoalService goalService;

    private Goal mockGoal;

    private Long expectedId;

    @BeforeEach
    public void setUp(){
        expectedId = 1L;
        mockGoal = new Goal("TestGoal",1000.00,15.00,"TEST", "");
        mockGoal.setId(1L);
    }

    @Test
    public void createGoalTest(){
        BDDMockito.doReturn(Optional.empty()).when(goalRepo).findByGoalName(any());
        BDDMockito.doReturn(mockGoal).when(goalRepo).save(any());
        Goal goal = goalService.create(mockGoal);
        Assertions.assertEquals(expectedId, goal.getId());

    }

    @Test
    public void getByIdTest(){
        BDDMockito.doReturn(Optional.of(mockGoal)).when(goalRepo).findByGoalName(any());
        Goal goal = goalService.getById(1L);
        Assertions.assertEquals(expectedId, goal.getId());
    }
}
