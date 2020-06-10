package cloud.cholewa.wow.user.service;

import cloud.cholewa.wow.common.ClockService;
import cloud.cholewa.wow.user.boundary.AccessTokenRepository;
import cloud.cholewa.wow.user.entity.AccessToken;
import cloud.cholewa.wow.user.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AccessTokenService {

    private final AccessTokenRepository accessTokenRepository;

    public String generateAccessToken(User user) {

        long tokenValidityTime = 600L;   //10min

        LocalDateTime issueTime = ClockService.now();
        LocalDateTime expiresTime = ClockService.inFuture(issueTime, tokenValidityTime);

        String token = Jwts.builder()
                .setIssuedAt(ClockService.getDate(issueTime))
                .setExpiration(ClockService.getDate(expiresTime))
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .claim("username", user.getUsername())
                .claim("email", user.getEmail())
                .signWith(SignatureAlgorithm.HS512, "secretPass")
                .compact();

        AccessToken accessToken = new AccessToken();
        accessToken.setUser(user);
        accessToken.setToken(token);
        accessToken.setExpiresAt(expiresTime);

        accessTokenRepository.save(accessToken);

        return token;
    }
}
