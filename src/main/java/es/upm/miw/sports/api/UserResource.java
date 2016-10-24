package es.upm.miw.sports.api;

import es.upm.miw.sports.controllers.UserController;
import es.upm.miw.sports.exceptions.NoValidEmailException;
import es.upm.miw.sports.exceptions.NoValidNickException;
import es.upm.miw.sports.exceptions.UserExistsException;

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
}
