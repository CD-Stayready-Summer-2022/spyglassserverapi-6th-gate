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

    @PutMapping("{id}/name")
    public ResponseEntity<Goal> updateGoalName(@PathVariable("id") Long id, @RequestBody Goal goal){
        Goal updatedGoal = goalService.updateName(id, goal.getGoalName());
        return new ResponseEntity<>(updatedGoal, HttpStatus.ACCEPTED);
    }

    @PutMapping("{id}/target-date")
    public ResponseEntity<Goal> updateTargetDate(@PathVariable("id") Long id, @RequestBody Goal goal){
        Goal updatedGoal = goalService.updateTargetDate(id, goal.getTargetDate());
        return new ResponseEntity<>(updatedGoal, HttpStatus.ACCEPTED);
    }

    @PutMapping("{id}/description")
    public ResponseEntity<Goal> updateDescription(@PathVariable("id") Long id, @RequestBody Goal goal){
        Goal updatedGoal = goalService.updateDescription(id, goal.getDescription());
        return new ResponseEntity<>(updatedGoal, HttpStatus.ACCEPTED);
    }

    @PutMapping("{id}/current-dollar-amount")
    public ResponseEntity<Goal> updateCurrentDollarAmount(@PathVariable("id") Long id, @RequestBody Goal goal){
        Goal updatedGoal = goalService.updateCurrentDollarAmount(id, goal.getCurrentDollarAmount());
        return new ResponseEntity<>(updatedGoal, HttpStatus.ACCEPTED);
    }

    @PutMapping("{id}/target-dollar-amount")
    public ResponseEntity<Goal> updateTargetDollarAmount(@PathVariable("id") Long id, @RequestBody Goal goal){
        Goal updatedGoal = goalService.updateTargetDollarAmount(id, goal.getTargetDollarAmount());
        return new ResponseEntity<>(updatedGoal, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteGoal(@PathVariable("id") Long id) throws ResourceNotFoundException{
        goalService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
