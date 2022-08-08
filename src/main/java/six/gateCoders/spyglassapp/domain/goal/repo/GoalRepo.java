package six.gateCoders.spyglassapp.domain.goal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface GoalRepo extends JpaRepository<Goal, Long> {
    Optional<Goal> findByGoalName(String goalName);
    List<Goal> findByTargetDate(Date date);
    List<Goal> findByProfileId(String profileId);
}
