package six.gateCoders.spyglassapp.domain.profile.dto;

import lombok.Data;
import six.gateCoders.spyglassapp.domain.profile.model.Profile;

@Data
public class ProfileDTO {

    private String id;

    private String fullName;

    private String email;

    public ProfileDTO(Profile profile){
        id = profile.getId();
        fullName = String.format("%s %s", profile.getFirstName(), profile.getLastName());
        email = profile.getEmail();
    }
}
