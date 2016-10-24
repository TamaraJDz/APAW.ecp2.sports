package es.upm.miw.sports.api;

import es.upm.miw.sports.controllers.SportController;
import es.upm.miw.sports.exceptions.NoValidSportNameException;
import es.upm.miw.sports.exceptions.SportExistsException;

public class SportResource {

	public void createSport(String sport) throws NoValidSportNameException, SportExistsException {
		if (checkSport(sport)) {
			throw new NoValidSportNameException(sport);
		}
		if (!new SportController().createSport(sport)) {
			throw new SportExistsException(sport);
		}
	}

	private boolean checkSport(String sport) {
		return sport == null || sport.isEmpty();
	}

}
