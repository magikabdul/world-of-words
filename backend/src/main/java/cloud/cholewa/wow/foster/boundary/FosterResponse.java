package cloud.cholewa.wow.foster.boundary;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Getter
public class FosterResponse {

    private final Long id;
    private final String fistName;
    private final String lastName;
    private final String username;
    private final String email;
}
