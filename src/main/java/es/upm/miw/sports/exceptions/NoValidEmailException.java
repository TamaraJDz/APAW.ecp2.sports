package es.upm.miw.sports.exceptions;

public class NoValidEmailException extends Exception {

	private static final long serialVersionUID = 8646267436060027184L;

	public NoValidEmailException(String email) {
		super("El email " + email + " no es válido.");
	}

}
