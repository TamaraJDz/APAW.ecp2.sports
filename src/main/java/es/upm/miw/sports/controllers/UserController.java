package es.upm.miw.sports.controllers;

import java.util.List;

import es.upm.miw.sports.daos.DaoFactory;
import es.upm.miw.sports.entities.Sport;
import es.upm.miw.sports.entities.User;
import es.upm.miw.sports.wrappers.NickListWrapper;
import es.upm.miw.sports.wrappers.UserListWrapper;
import es.upm.miw.sports.wrappers.UserWrapper;

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

	public UserListWrapper userList() {
        List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
        UserListWrapper userListWrapper = new UserListWrapper();
        for (User user : userList) {
            userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
        }
        return userListWrapper;
	}

	public NickListWrapper findUsersBySport(String sport) {
		List<User> userList = DaoFactory.getFactory().getUserDao().findUsersBySport(sport);
        NickListWrapper userNickListWrapper = new NickListWrapper();
        for (User user : userList) {
            userNickListWrapper.addNick(user.getNick());
        }
        return userNickListWrapper;
	}

	public boolean userAddSport(String nick, String sport) {
        User user = findUserByNick(nick);
        if (user != null && user.hasSport(sport)) {
        	return false;
        }        
        user.setSport(DaoFactory.getFactory().getSportDao().findSportByName(sport));
        return true;
	}

}
