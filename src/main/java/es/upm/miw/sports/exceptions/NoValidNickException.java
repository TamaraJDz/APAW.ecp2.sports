package es.upm.miw.sports.exceptions;

public class NoValidNickException extends Exception {

	private static final long serialVersionUID = -2131332248728266257L;

	public NoValidNickException(String nick) {
		super("El nick " + nick + " no es válido.");
	}

}
