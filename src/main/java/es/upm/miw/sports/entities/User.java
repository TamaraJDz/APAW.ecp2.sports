package es.upm.miw.sports.entities;

public class User {
	private int id;
	
	private String nick;
	
	private String email;
	
	private Sport sport;
	
	public User(String nick, String email) {
		this.nick = nick;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	public boolean hasSport(String sportName){
		return this.sport.getName().equals(sportName);
	}
}
