package es.upm.miw.sports.exceptions;

public class SportNotExistsException extends Exception {
	private static final long serialVersionUID = 3829476763336768643L;
	
	public SportNotExistsException(String sport) {
		super("El deporte " + sport + " no existe.");
	}
}
