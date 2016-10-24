package es.upm.miw.sports.controllers;

import es.upm.miw.sports.daos.DaoFactory;
import es.upm.miw.sports.entities.Sport;

public class SportController {

	public boolean createSport(String sport) {
		if (findSport(sport) != null) {
			return false;
		}
		DaoFactory.getFactory().getSportDao().create(new Sport(sport));
		return true;
	}

	public Sport findSport(String sport) {
		return DaoFactory.getFactory().getSportDao().findSportByName(sport);
	}

}
