package es.upm.miw.sports.exceptions;

public class SportExistsException extends Exception {

	private static final long serialVersionUID = 4117216429931315721L;

	public SportExistsException(String sport) {
		super("El deporte " + sport + " ya existe.");
	}
}
