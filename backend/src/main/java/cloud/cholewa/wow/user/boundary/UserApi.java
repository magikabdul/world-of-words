package cloud.cholewa.wow.user.boundary;

import cloud.cholewa.wow.foster.boundary.FosterRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class UserApi {

    @PostMapping("login")
    public ResponseEntity<String> userLogin(@RequestBody UserLogin userLogin) {
        return new ResponseEntity<>("works login: " , HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> registerFoster (@RequestBody FosterRegister fosterRegister) {
        return new ResponseEntity<>("works register: ", HttpStatus.CREATED);
    }
}
