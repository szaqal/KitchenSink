package szaq.logback.demo.services;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import szaq.logback.demo.dao.UserDao;
import szaq.logback.demo.model.User;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Service
public class UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Resource
	private UserDao userDao;
	
	
	public User get(Integer id) {
		return userDao.get(id);
	}


	public void store(User user) {
		userDao.store(user);
	}

	@PostConstruct
	public void postConstruct() {
		LOG.info("{} initialized", this.getClass().getName() );
	}
}
