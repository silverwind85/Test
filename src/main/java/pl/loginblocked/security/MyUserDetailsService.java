package pl.loginblocked.security;

import java.util.Arrays;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.loginblocked.entity.User;
import pl.loginblocked.repository.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {
	private UserRepository userRepository;
	
	@Autowired
    private LoginAttemptService loginAttemptService;
  
    @Autowired
    private HttpServletRequest request;

	public MyUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        String ip = getClientIP();
        if (loginAttemptService.isBlocked(ip)) {
            throw new RuntimeException("blocked");
        }
       
        	if (user == null) {
        
            throw new UsernameNotFoundException("USER NOT FOUND");
        }

        
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isActive(),
                true,
                true,
                true,
                getAuthorities("ROLE_" + user.getRole()));
       
    }

	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}
	private String getClientIP() {
	    String xfHeader = request.getHeader("X-Forwarded-For");
	    if (xfHeader == null){
	        return request.getRemoteAddr();
	    }
	    return xfHeader.split(",")[0];
	}
}
