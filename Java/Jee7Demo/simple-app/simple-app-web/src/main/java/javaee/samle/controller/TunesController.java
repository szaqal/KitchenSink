package javaee.samle.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import javaee.sample.model.Tune;
import javaee.sample.service.TuneService;

@Model
public class TunesController {
	
	private static final String SUCCESS_VIEW = "tunes.jsf";

	@Inject
	private TuneService tuneService;

	@Inject
	private FacesContext facesContext;

	private Tune newTune;

	@Produces
	@Named
	public List<Tune> getTunes() {
		return tuneService.getAll();
	}

	@Produces
	@Named
	public Tune newTune() {
		return newTune;
	}

	public void addTune() throws Exception {
		try {
			tuneService.store(newTune);
			initNewModel();
			facesContext.getExternalContext().redirect(SUCCESS_VIEW);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void delete(Tune tune) throws Exception {
		try {
			tuneService.remove(tune);
			facesContext.getExternalContext().redirect(SUCCESS_VIEW);
		} catch (Exception e) {
			throw e;
		}
	}

	@PostConstruct
	public void initNewModel() {
		newTune = new Tune();
	}

}
