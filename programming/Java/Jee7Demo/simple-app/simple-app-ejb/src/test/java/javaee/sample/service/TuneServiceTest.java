package javaee.sample.service;

import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;

import com.google.common.collect.Lists;

import javaee.sample.model.Tune;
import javaee.sample.repository.TunesRepository;

@RunWith(MockitoJUnitRunner.class)
public class TuneServiceTest {

	@InjectMocks
	private TuneService tuneService;
	
	@Mock
	private TunesRepository tunesRepository;
	
	@Mock
	private Logger log;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(tunesRepository.getByArtist("Artist")).thenReturn(Lists.newArrayList(new Tune()));
		Mockito.when(tunesRepository.getByGenre("Other")).thenReturn(Lists.newArrayList());
		Mockito.when(tunesRepository.getTunes()).thenReturn(Lists.newArrayList(new Tune()));
	}

	@Test
	public void getByGenre() {
		List<Tune> byGenre = tuneService.getByGenre("Other");
		Assertions.assertThat(byGenre).hasSize(0);
		Mockito.verify(tunesRepository).getByGenre("Other");
	}

	@Test
	public void getByArtist() {
		List<Tune> byArtist = tuneService.getByArtist("Artist");
		Assertions.assertThat(byArtist).hasSize(1);
		Mockito.verify(tunesRepository).getByArtist("Artist");
	}

	@Test
	public void getAll() {
		List<Tune> all = tuneService.getAll();
		Assertions.assertThat(all).hasSize(1);
		Mockito.verify(tunesRepository).getTunes();
	}

	@Test
	public void store() {
		Tune tune = new Tune();
		tuneService.store(tune);
		Mockito.verify(tunesRepository).store(Mockito.eq(tune));
	}

	@Test
	public void remove() {
		Tune tune = new Tune();
		tuneService.remove(tune);
		Mockito.verify(tunesRepository).remove(Mockito.eq(tune));
	}

}
