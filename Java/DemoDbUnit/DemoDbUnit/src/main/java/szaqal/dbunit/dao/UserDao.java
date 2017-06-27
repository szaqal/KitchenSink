package szaqal.dbunit.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import szaqal.dbunit.model.User;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Repository
public interface UserDao {

	@Select("SELECT * FROM user WHERE id = #{id}")
	User get(@Param("id") Integer id);

	@Insert("INSERT INTO user (id, firstName, lastName) VALUES (#{id}, #{firstName}, #{lastName})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void store(User user);

}
