package es.upm.miw.sports.daos;

import java.util.List;
import es.upm.miw.sports.entities.User;

public interface UserDao extends GenericDao<User, Integer>{
	List<User> findUsersBySport(String sportName);

	User findUserByNick(String nick);
}
