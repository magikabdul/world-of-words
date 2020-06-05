package cloud.cholewa.wow.user.boundary;

import cloud.cholewa.wow.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class UserApi {

    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<String> userLogin(@RequestBody UserLogin userLogin) {
        return new ResponseEntity<>("works login: " , HttpStatus.OK);
    }

    @GetMapping("activate")
    public ResponseEntity<String> activateUser(@RequestParam String token) {
        userService.activateUser(token);
        return new ResponseEntity<>("Account activated", HttpStatus.OK);
    }
}
