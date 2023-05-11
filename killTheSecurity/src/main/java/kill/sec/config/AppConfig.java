package kill.sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import kill.sec.service.UserLogInService;

@Configuration
public class AppConfig {
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new UserLogInService();
    }
	

}
