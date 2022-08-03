package six.gateCoders.spyglassapp.domain.goal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.goal.repo.GoalRepo;

import java.util.Date;
import java.util.Optional;

@Service
public class GoalServinceImpl implements GoalService{

    private GoalRepo goalRepo;

    @Autowired
    public GoalServinceImpl(GoalRepo goalRepo) {
        this.goalRepo = goalRepo;
    }

    @Override
    public Iterable<Goal> getall() {
        return null;
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
    public Optional<Goal> getByName(String goalName) throws ResourceNotFoundException {
        return goalRepo.findByName(goalName);
    }

    @Override
    public Goal updateName(Long id, String goalName) throws ResourceNotFoundException {
        Goal goal = getById(id);
        goal.setGoalName(goalName);
        return goalRepo.save(goal);
    }

    @Override
    public Goal updateTargetDate(Long id, Date targetDate) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Goal updateDescription(Long id, String description) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Goal updateCurrentDollarAmount(Long id, double currentDollarAmount) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Goal updateTargetDollarAmount(Long id, double targetDollarAmount) throws ResourceNotFoundException {
        return null;
    }


    @Override
    public void delete(Long Id) throws ResourceNotFoundException {
        Goal goal = getById(Id);
        goalRepo.delete(goal);
    }
}
