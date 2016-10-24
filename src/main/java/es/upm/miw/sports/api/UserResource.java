package es.upm.miw.sports.api;

import es.upm.miw.sports.controllers.SportController;
import es.upm.miw.sports.controllers.UserController;
import es.upm.miw.sports.exceptions.NoValidEmailException;
import es.upm.miw.sports.exceptions.NoValidNickException;
import es.upm.miw.sports.exceptions.NoValidSportNameException;
import es.upm.miw.sports.exceptions.SportNotExistsException;
import es.upm.miw.sports.exceptions.UserExistsException;
import es.upm.miw.sports.exceptions.UserHasSportException;
import es.upm.miw.sports.exceptions.UserNotExistsException;
import es.upm.miw.sports.wrappers.NickListWrapper;
import es.upm.miw.sports.wrappers.UserListWrapper;

public class UserResource {

	public void createUser(String nick, String email)
			throws NoValidNickException, NoValidEmailException, UserExistsException {
		if (checkField(nick)) {
			throw new NoValidNickException(nick);
		}
		if (checkField(email)) {
			throw new NoValidEmailException(email);
		}
		if (!new UserController().createUser(nick, email)) {
			throw new UserExistsException(nick);
		}
	}

	private boolean checkField(String field) {
		return field == null || field.isEmpty();
	}

	public UserListWrapper userList() {
		return new UserController().userList();
	}

	public NickListWrapper findUsersBySport(String sport) throws NoValidSportNameException, SportNotExistsException {
		validateSport(sport);
        return new UserController().findUsersBySport(sport);
    }

    private void validateSport(String sport) throws NoValidSportNameException, SportNotExistsException {
        if (checkField(sport)) {
            throw new NoValidSportNameException(sport);
        }
        if (new SportController().findSport(sport) == null) {
            throw new SportNotExistsException(sport);
        }
    }

	public void userAddSport(String nick, String sport) throws UserHasSportException, SportNotExistsException, UserNotExistsException, NoValidSportNameException, NoValidNickException {
        if (new UserController().findUserByNick(nick) == null) {
            throw new UserNotExistsException(nick);
        }
        if (new SportController().findSport(sport) == null) {
            throw new SportNotExistsException(sport);
        }
        if (!new UserController().userAddSport(nick, sport)) {
            throw new UserHasSportException(nick, sport);
        }	
        if (checkField(nick)) {
            throw new NoValidNickException(nick);
        }
        if (checkField(sport)) {
            throw new NoValidSportNameException(sport);
        }
	}
}
