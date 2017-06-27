package szaqal.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Lists;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class UserToken extends AbstractAuthenticationToken {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserToken.class);

	private static final long serialVersionUID = -1995181658874465151L;
	
    /**
     * User token
     */
    private final Object credentials;
    
    /**
     * User name.
     */
    private final Object principal;

	public UserToken(Object credentials, Object principal) {
		super(Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER")));
		this.credentials = credentials;
		this.principal = principal;
		LOG.info("USERTOKEN AUTHENTICATION CREATED [{}][{}][{}]", credentials, principal, this);
	}

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

}
