package es.upm.miw.sports.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.sports.daos.UserDao;
import es.upm.miw.sports.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {
	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public List<User> findUsersBySport(String sportName) {
		List<User> users = this.findAll();
		List<User> usersBySport = new ArrayList<>();
		for (User user : users) {
			if (user.hasSport(sportName)) {
				usersBySport.add(user);
			}
		}
		return usersBySport;
	}

	@Override
	public User findUserByNick(String nick) {
		List<User> users = this.findAll();
		for (User user : users) {
			if (user.getNick().equals(nick)) {
				return user;
			}
		}
		return null;
	}
}
