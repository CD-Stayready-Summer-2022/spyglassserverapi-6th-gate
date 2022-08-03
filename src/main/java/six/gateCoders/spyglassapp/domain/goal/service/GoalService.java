package six.gateCoders.spyglassapp.domain.goal.service;

import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;

public interface GoalService {
    Iterable<Goal> getall();
    Goal create (Goal goal) throws ResourceCreationError;
    Goal getById(Long id) throws ResourceNotFoundException;
    Goal getByName(String goalName) throws ResourceNotFoundException;
    Goal update(Long id, Goal goalDetail) throws ResourceNotFoundException;
    void delete (Long Id) throws ResourceNotFoundException;

}
