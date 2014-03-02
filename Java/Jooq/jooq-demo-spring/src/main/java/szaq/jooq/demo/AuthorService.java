package szaq.jooq.demo;

import javax.annotation.Resource;

import org.jooq.DSLContext;
import org.jooq.Record2;
import org.springframework.stereotype.Service;

import szaq.jooq.demo.gen.Tables;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
@Service
public class AuthorService {

	@Resource
	private DSLContext dslContext;

	public void save(int id, String firstName, String lastName) {
		dslContext.insertInto(Tables.AUTHOR)
				.set(Tables.AUTHOR.ID, id)
				.set(Tables.AUTHOR.FIRST_NAME, firstName)
				.set(Tables.AUTHOR.LAST_NAME, lastName).execute();
	}

	public Record2<String, String> get() {
		Record2<String, String> fetchOne = dslContext
				.select(Tables.AUTHOR.FIRST_NAME, Tables.AUTHOR.LAST_NAME)
				.from(Tables.AUTHOR).fetchOne();
		return fetchOne;
	}
}
