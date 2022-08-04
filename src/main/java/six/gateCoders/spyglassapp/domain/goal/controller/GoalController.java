package six.gateCoders.spyglassapp.domain.goal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;
import six.gateCoders.spyglassapp.domain.goal.service.GoalService;

@RestController
@RequestMapping("/api/v1/goals")
public class GoalController {
    private GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) throws ResourceNotFoundException{

        return  null;
    }

    @GetMapping
    public ResponseEntity<Iterable<Goal>> getAllGoals(){

        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable("id") Long id) throws ResourceNotFoundException{

        return null;
    }

    @PostMapping("{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable("id") Long id, @RequestBody Goal goalDetail) throws ResourceNotFoundException{

        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteGoal(@PathVariable("id") Long id) throws ResourceNotFoundException{
        goalService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
