package es.upm.miw.sports.exceptions;

public class UserNotExistsException extends Exception {

	private static final long serialVersionUID = -8060801496530449212L;

	public UserNotExistsException(String nick) {
		super("No se ha encontrado al usuario " + nick);
	}

}
