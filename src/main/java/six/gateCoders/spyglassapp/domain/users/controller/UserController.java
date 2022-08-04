package six.gateCoders.spyglassapp.domain.users.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import six.gateCoders.spyglassapp.domain.users.service.UserService;
import six.gateCoders.spyglassapp.security.models.FireBaseUser;

@RestController
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<FireBaseUser> getUserInfo(@AuthenticationPrincipal FireBaseUser user) {
        log.info("A request was made by user with id {} and email {}",user.getUid(), user.getEmail());
        Boolean saved = userService.doesExist(user.getUid());
        log.info("Is the user saved {}", saved);
        return ResponseEntity.ok(user);
    }

}