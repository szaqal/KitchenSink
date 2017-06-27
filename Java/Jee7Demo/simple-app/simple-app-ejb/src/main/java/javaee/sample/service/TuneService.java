package javaee.sample.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import javaee.sample.model.Tune;
import javaee.sample.repository.TunesRepository;



/**
 * Pointless not required but added to satisfy all layers
 */
@Stateless
public class TuneService {
	
    @Inject
    private Logger log;
    
    @Inject
    private TunesRepository tunesRepository;

	public List<Tune> getByGenre(String genre) {
		Preconditions.checkNotNull(!Strings.isNullOrEmpty(genre), "Genre value is required for data retrieval");
		log.debug("Get by genre {}", genre);
		return tunesRepository.getByGenre(genre);
	}

	public List<Tune> getByArtist(String artist) {
		Preconditions.checkNotNull(!Strings.isNullOrEmpty(artist), "Artist value is required for data retrieval");
		log.debug("Get by artist {}", artist);
		return tunesRepository.getByArtist(artist);
	}
	
	public List<Tune> getAll() {
		log.debug("Retrieve all items");
		return tunesRepository.getTunes();
	}

	public void store(Tune tune) {
		Preconditions.checkNotNull(tune, "Tune object is required for save");
		log.debug("Storing object {}", tune);
		tunesRepository.store(tune);
	}

	public void remove(Tune tune) {
		Preconditions.checkNotNull(tune, "Tune object is required for save");
		log.debug("Removing object {}", tune);
		tunesRepository.remove(tune);
	}
}
