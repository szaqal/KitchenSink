package szaqal.dbunit.services;

import szaqal.dbunit.model.User;


/**
 * @author malczyk.pawel@gmail.com
 *
 */
public interface UserService {

	void store(User user);
	
	User get(Integer id);
}
