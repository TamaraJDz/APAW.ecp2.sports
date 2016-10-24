package es.upm.miw.sports.exceptions;

public class NoValidSportNameException extends Exception {
	private static final long serialVersionUID = -6978955587482363694L;

	public NoValidSportNameException(String sport) {
		super("El deporte " + sport + " no es válido.");
	}
}
