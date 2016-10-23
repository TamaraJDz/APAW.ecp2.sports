package es.upm.miw.sports.daos;

import es.upm.miw.sports.entities.Sport;

public interface SportDao extends GenericDao<Sport, Integer>{
	Sport findSportByName(String sportName);
}
