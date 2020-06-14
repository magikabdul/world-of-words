package cloud.cholewa.wow.configuration;

import cloud.cholewa.wow.common.ClockService;
import cloud.cholewa.wow.user.entity.AccessToken;
import cloud.cholewa.wow.user.service.AccessTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TokenFilter extends GenericFilterBean {

    private final AccessTokenService accessTokenService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String authorizationHeader = httpRequest.getHeader("Authorization");

        if (authorizationHeader != null) {
            accessTokenService.getAccessToken(authorizationHeader.substring(7).trim())
                    .filter(accessToken -> accessToken.getExpiresAt().isAfter(ClockService.now()))
                    .map(AccessToken::getUser)
                    .map(user -> new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()))
                    .ifPresent(usernamePasswordAuthenticationToken -> {
                        SecurityContextHolder.getContext()
                                .setAuthentication(usernamePasswordAuthenticationToken);
                    });
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
