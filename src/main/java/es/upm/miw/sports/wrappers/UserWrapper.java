package es.upm.miw.sports.wrappers;

public class UserWrapper {
    private String nick;

    private String email;

    public UserWrapper(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{\"nick\":\"" + nick + "\", \"email\":\"" + email + "\"}";
    }
}
