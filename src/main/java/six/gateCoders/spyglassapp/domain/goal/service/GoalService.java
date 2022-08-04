package six.gateCoders.spyglassapp.domain.goal.service;

import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface GoalService {
    List<Goal> getall();
    Goal create (Goal goal) throws ResourceCreationError;
    Goal getById(Long id) throws ResourceNotFoundException;
    Optional<Goal> getByName(String goalName) throws ResourceNotFoundException;
    Goal updateName(Long id, String goalName) throws ResourceNotFoundException;
    Goal updateTargetDate(Long id, Date targetDate) throws ResourceNotFoundException;
    Goal updateDescription(Long id, String description) throws ResourceNotFoundException;
    Goal updateCurrentDollarAmount(Long id, double currentDollarAmount) throws ResourceNotFoundException;
    Goal updateTargetDollarAmount(Long id, double targetDollarAmount) throws ResourceNotFoundException;
    Goal update(Long id, Goal goal) throws ResourceNotFoundException;
    void delete (Long Id) throws ResourceNotFoundException;

}
