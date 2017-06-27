package szaqal.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.google.common.base.Optional;
import com.google.common.base.Strings;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
public class UserTokenEntrypoint implements AuthenticationEntryPoint {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserTokenEntrypoint.class);


	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		String userName = Optional.fromNullable(request.getHeader("userName")).or("");
		String userToken = Optional.fromNullable(request.getHeader("userToken")).or("");
		LOG.info("USERTOKEN AUTHENTICATION ENTRY POINT [{}] [{}]", userName, userToken);
		if(Strings.isNullOrEmpty(userToken)|| Strings.isNullOrEmpty(userName)) {
			if(request.getSession() != null) {
				request.getSession().invalidate();
			}
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
		} else {
			response.sendRedirect("/custom-auth/secured/authorize");
		}
	}


}
