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
        goal = goalService.create(goal);
        return new ResponseEntity<>(goal, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Goal>> getAllGoals(){
        Iterable<Goal> goals = goalService.getall();
        return new ResponseEntity<>(goals, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable("id") Long id) throws ResourceNotFoundException{
        Goal goal = goalService.getById(id);
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @PostMapping("{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable("id") Long id, @RequestBody Goal goalDetail) throws ResourceNotFoundException{
        Goal goal = goalService.update(id, goalDetail);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteGoal(@PathVariable("id") Long id) throws ResourceNotFoundException{
        goalService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
