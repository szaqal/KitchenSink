package szaqal.dbunit.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import szaqal.dbunit.dao.UserDao;
import szaqal.dbunit.model.User;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public void store(User user) {
		userDao.store(user);
	}

	@Override
	public User get(Integer id) {
		return userDao.get(id);
	}

}
