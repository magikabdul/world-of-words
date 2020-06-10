package cloud.cholewa.wow.user.boundary;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessTokenResponse {
    private final String token;
}
