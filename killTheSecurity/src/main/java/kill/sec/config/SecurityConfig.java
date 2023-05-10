package kill.sec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
	        .mvcMatchers("/", "/home").permitAll()
	        .antMatchers("admin", "/admin").authenticated()
	        .anyRequest().authenticated()
	        .and();
		http.formLogin()
			.and()
		    .logout()
		        .permitAll();
	}
	//이렇게 코딩을 해도 모든 uri 요청이 다 허용된다. 왜냐면 필터를 안걸어줬기 떄문. -> web.xml
	
	

}
