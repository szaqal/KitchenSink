package szaqal.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.google.common.base.Optional;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class UserTokenFilter extends AbstractAuthenticationProcessingFilter {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserTokenFilter.class);

	protected UserTokenFilter() {
		super("/secured/authorize");
		setAuthenticationSuccessHandler(new UserTokenAuthSuccessHandler());
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException,
			ServletException {
		String userName = Optional.fromNullable(request.getHeader("userName")).or("");
		String userToken = Optional.fromNullable(request.getHeader("userToken")).or("");
		LOG.info("USERTOKEN CREATING AUTHENTICATION OBJECT [{}] [{}]", userName, userToken);
		Authentication authenticate = getAuthenticationManager().authenticate(new UserToken(userToken, userName));
		return authenticate;
	}
	

}
