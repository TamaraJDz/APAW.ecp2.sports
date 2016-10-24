package es.upm.miw.sports.exceptions;

public class UserExistsException extends Exception {

	private static final long serialVersionUID = 4823982113441542765L;

	public UserExistsException(String nick) {
		super("El nick " + nick + " ya existe.");
	}

}
