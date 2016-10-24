package es.upm.miw.sports.exceptions;

public class UserHasSportException extends Exception {

	private static final long serialVersionUID = -2864953956207231112L;
	
	public UserHasSportException(String user, String sport) {
		super("El usuario " + user + " ya practica el deporte " + sport);
	}
}
