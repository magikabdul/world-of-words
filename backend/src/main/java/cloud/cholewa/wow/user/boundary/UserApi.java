package cloud.cholewa.wow.user.boundary;

import cloud.cholewa.wow.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
@CrossOrigin
public class UserApi {

    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<AccessTokenResponse> userLogin(@RequestBody UserLogin userLogin) {
        return new ResponseEntity<>(userService.issueAccessToken(userLogin), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("activate")
    public ResponseEntity<String> activateUser(@RequestParam String token) {
        userService.activateUser(token);
        return new ResponseEntity<>("Account activated", HttpStatus.OK);
    }

    //TODO --delete below

    @GetMapping("test")
    public ResponseEntity<String> test(Principal principal) {
        return new ResponseEntity<>("You are: " + principal.getName(), HttpStatus.OK);
    }
}
