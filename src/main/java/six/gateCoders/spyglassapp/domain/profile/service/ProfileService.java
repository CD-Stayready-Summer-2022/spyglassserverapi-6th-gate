package six.gateCoders.spyglassapp.domain.profile.service;

import six.gateCoders.spyglassapp.domain.goal.model.Goal;

public interface ProfileService {
    Iterable<Goal> getall();
    void delete (Long Id);

}
