package six.gateCoders.spyglassapp.security.services;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceCreationError;
import six.gateCoders.spyglassapp.domain.core.exceptions.ResourceNotFoundException;
import six.gateCoders.spyglassapp.domain.profile.dto.ProfileCreateRequest;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;

@Service
@Slf4j
public class FirebaseUserMgrServiceImpl implements FirebaseUserMgrService{
    @Override
    public String createFireBaseUser(ProfileCreateRequest userDetail) throws ResourceCreationError {
        try {
            String displayName = String.format("%s %s", userDetail.getFirstName(), userDetail.getLastName());
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(userDetail.getEmail())
                    .setEmailVerified(true)
                    .setPassword(userDetail.getPassword())
                    .setDisplayName(displayName)
                    .setDisabled(false);
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            return userRecord.getUid();
        } catch (FirebaseAuthException e){
            throw new ResourceCreationError(e.getMessage());
        }
    }

    @Override
    public void updateFireBaseUser(Profile userDetail) throws ResourceNotFoundException {
        try {
            String displayName = String.format("%s %s", userDetail.getFirstName(), userDetail.getLastName());
            UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(userDetail.getId())
                    .setEmail(userDetail.getEmail())
                    .setDisplayName(displayName);
            FirebaseAuth.getInstance().updateUser(request);
        }catch (FirebaseAuthException e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @Override
    public void deleteFireBaseUser(String id) throws ResourceNotFoundException {
        try {
            FirebaseAuth.getInstance().deleteUser(id);
        }catch (FirebaseAuthException e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
}
