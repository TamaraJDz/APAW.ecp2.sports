package es.upm.miw.sports.daos.memory;

import es.upm.miw.sports.daos.DaoFactory;
import es.upm.miw.sports.daos.SportDao;
import es.upm.miw.sports.daos.UserDao;

public class DaoFactoryMemory extends DaoFactory {

	private SportDao sportDao;

	private UserDao userDao;

	@Override
	public SportDao getSportDao() {
		if (sportDao == null) {
			sportDao = new SportDaoMemory();
		}
		return sportDao;
	}

	@Override
	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDaoMemory();
		}
		return userDao;
	}

}
