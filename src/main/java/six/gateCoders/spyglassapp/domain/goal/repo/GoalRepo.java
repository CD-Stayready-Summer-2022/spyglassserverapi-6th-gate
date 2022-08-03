package six.gateCoders.spyglassapp.domain.goal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import six.gateCoders.spyglassapp.domain.goal.model.Goal;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface GoalRepo extends JpaRepository<Goal, Long> {
    Optional<Goal> findByName(String name);
    List<Goal> findByTargetDate(Date date);
}
