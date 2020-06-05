package cloud.cholewa.wow.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "application.admin.configuration")
@Setter
@Getter
@Configuration
public class AdminData {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String mail;
}
