package six.gateCoders.spyglassapp.domain.goal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.goal.repo.GoalRepo;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;
import six.gateCoders.spyglassapp.domain.profile.repo.ProfileRepo;
import six.gateCoders.spyglassapp.domain.profile.service.ProfileService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GoalServinceImpl implements GoalService{
    
    private GoalRepo goalRepo;

    @Autowired
    public GoalServinceImpl(GoalRepo goalRepo) {
        this.goalRepo = goalRepo;
    }

    @Override
    public List<Goal> getall() {
        return goalRepo.findAll();
    }

    @Override
    public Goal create(Goal goal) throws ResourceCreationError {
        return goalRepo.save(goal);
    }

    @Override
    public Goal getById(Long id) throws ResourceNotFoundException {
        return goalRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("resource with Id not found"));
    }

    @Override
    public List<Goal> getByProfileId(String profileId) {
        return goalRepo.findByProfileId(profileId);
    }

    @Override
    public Optional<Goal> getByName(String goalName) throws ResourceNotFoundException {
        return goalRepo.findByGoalName(goalName);
    }

    @Override
    public Goal updateName(Long id, String goalName) throws ResourceNotFoundException {
        Goal goal = getById(id);
        goal.setGoalName(goalName);
        return goalRepo.save(goal);
    }

    @Override
    public Goal updateTargetDate(Long id, Date targetDate) throws ResourceNotFoundException {
        Goal goal = getById(id);
        goal.setTargetDate(targetDate);
        return goalRepo.save(goal);
    }

    @Override
    public Goal updateDescription(Long id, String description) throws ResourceNotFoundException {
        Goal goal = getById(id);
        goal.setDescription(description);
        return goalRepo.save(goal);
    }

    @Override
    public Goal updateCurrentDollarAmount(Long id, double currentDollarAmount) throws ResourceNotFoundException {
        Goal goal = getById(id);
        goal.setCurrentDollarAmount(currentDollarAmount);
        return goalRepo.save(goal);
    }

    @Override
    public Goal updateTargetDollarAmount(Long id, double targetDollarAmount) throws ResourceNotFoundException {
        Goal goal = getById(id);
        goal.setTargetDollarAmount(targetDollarAmount);
        return goalRepo.save(goal);
    }

    @Override
    public Goal update(Long id, Goal goal) throws ResourceNotFoundException {
        Goal savedGoal = getById(id);
        savedGoal.setGoalName(goal.getGoalName());
        savedGoal.setSteps(goal.getSteps());
        savedGoal.setCreationDate(goal.getCreationDate());
        savedGoal.setTargetDate(goal.getTargetDate());
        savedGoal.setTargetDollarAmount(goal.getTargetDollarAmount());
        savedGoal.setCurrentDollarAmount(goal.getCurrentDollarAmount());
        return goalRepo.save(goal);
    }


    @Override
    public void delete(Long Id) throws ResourceNotFoundException {
        Goal goal = getById(Id);
        goalRepo.delete(goal);
    }
}
