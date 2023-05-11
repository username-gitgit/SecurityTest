package kill.sec.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailVO implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String username; // ID
	private String password; // PW
	private List<GrantedAuthority> authorities;
	
	// setter
	public void setUsername(String username) {
		this.username = username;
	}

	// setter
	public void setPassword(String password) {
		this.password = password;
	}

	// setter
	public void setAuthorities(List<String> authList) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (int i = 0; i < authList.size(); i++) {
			authorities.add(new SimpleGrantedAuthority(authList.get(i)));
		}

		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	// 계정이 만료 되지 않았는가?
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	// 계정이 잠기지 않았는가?
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	// 패스워드가 만료되지 않았는가?
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	// 계정이 활성화 되었는가?
	@Override
	public boolean isEnabled() {
		return true;
	}

}
