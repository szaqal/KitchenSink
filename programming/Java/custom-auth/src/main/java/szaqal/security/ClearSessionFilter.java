package szaqal.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class ClearSessionFilter extends GenericFilterBean {
	
	private static final Logger LOG = LoggerFactory.getLogger(ClearSessionFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		SecurityContextHolder.getContext().setAuthentication(null);
		LOG.info("USERTOKEN END");
	}

}
