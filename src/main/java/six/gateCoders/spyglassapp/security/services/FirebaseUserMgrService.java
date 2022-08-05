package six.gateCoders.spyglassapp.security.services;


import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.profile.dto.ProfileCreateRequest;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;

//TODO: add resourceUpdateException and update on firebadeUserMgrService
public interface FirebaseUserMgrService {
    String createFireBaseUser(ProfileCreateRequest userDetail) throws ResourceCreationError;
    void updateFireBaseUser(Profile userDetail) throws ResourceCreationError;
    void deleteFireBaseUser(String id) throws ResourceCreationError;
}
