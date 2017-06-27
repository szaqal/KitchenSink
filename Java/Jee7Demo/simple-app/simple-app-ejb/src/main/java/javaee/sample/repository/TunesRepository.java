package javaee.sample.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;

import com.google.common.base.Preconditions;

import javaee.sample.model.Tune;

@ApplicationScoped
public class TunesRepository implements BaseRepository {
	
    @Inject
    private Logger log;
	
	@Inject
	private EntityManager entityManager;

	
	public List<Tune> getTunes() {
		log.info("Retrieving all tunes");
		return listResults(entityManager, Tune.ALL, Tune.class);
	}
	
	public List<Tune> getByGenre(String genre) {
		Preconditions.checkNotNull(genre, "Email value is requried");
		log.info("Retrieving by genre {}", genre);
		return getList(Tune.BY_GENRE, Pair.of("genre", genre));
	}
	
	public List<Tune> getByArtist(String artist) {
		Preconditions.checkNotNull(artist, "Email value is requried");
		log.info("Retrieving by artist {}", artist);
		return getList(Tune.BY_ARTIST, Pair.of("artist", artist));
	}
	
	
	public List<Tune> getList( String query, Pair<String, Object> arg) {
		log.info("Retrieving by args {}", arg);
		return listResults(entityManager, query, Tune.class, arg);
	}
	
	public void store(Tune tune) {
		store(entityManager, tune);
	}

	public void remove(Tune tune) {
		remove(entityManager, tune);
	}

	public Tune get(Long tuneId) {
		return get(entityManager, tuneId, Tune.class);
	}

}
