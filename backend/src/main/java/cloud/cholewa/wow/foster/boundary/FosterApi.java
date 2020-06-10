package cloud.cholewa.wow.foster.boundary;

import cloud.cholewa.wow.foster.service.FosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/fosters")
@RequiredArgsConstructor
public class FosterApi {

    private final FosterService fosterService;

    @PostMapping("/add")
    public ResponseEntity<FosterResponse> addFoster(@RequestBody FosterRegister fosterRegister) {
        FosterResponse response = fosterService.add(fosterRegister);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
