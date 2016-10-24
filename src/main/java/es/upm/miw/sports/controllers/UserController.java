package es.upm.miw.sports.controllers;

import es.upm.miw.sports.daos.DaoFactory;
import es.upm.miw.sports.entities.User;

public class UserController {

	public boolean createUser(String nick, String email) {
        if (findUserByNick(nick) != null) {           
            return false;
        }
        DaoFactory.getFactory().getUserDao().create(new User(nick, email));
        return true;
	}

    public User findUserByNick(String nick) {
        return DaoFactory.getFactory().getUserDao().findUserByNick(nick);
    }

}
