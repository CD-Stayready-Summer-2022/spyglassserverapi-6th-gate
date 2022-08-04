package six.gateCoders.spyglassapp.domain.users.service;

import six.gateCoders.spyglassapp.domain.users.models.UserProfile;

public interface UserService {
    UserProfile create(UserProfile userProfile);
    Boolean doesExist(String id);
}
