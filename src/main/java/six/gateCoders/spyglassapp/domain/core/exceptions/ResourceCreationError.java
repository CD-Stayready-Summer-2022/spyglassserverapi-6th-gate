package six.gateCoders.spyglassapp.domain.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceCreationError extends  RuntimeException{
    public ResourceCreationError(String msg){
        super(msg);
    }
}
