package cloud.cholewa.wow.configuration;

import cloud.cholewa.wow.user.service.UserService;
import lombok.RequiredArgsConstructor;
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
public class TokenFilter {//extends GenericFilterBean {

//    private final UserService userService;
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//
//        String authorizationHeader = httpRequest.getHeader("Authorization");
//
//        if (authorizationHeader != null) {
//TODO
//        }
//    }
}
