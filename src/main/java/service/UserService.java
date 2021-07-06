package service;

import entity.User;
import storage.UserStorage;

public class UserService {
    private UserStorage userStorage = new UserStorage();

    public boolean addUser(User user) {
        if (userStorage.existByUsername(user.getUsername())) {
            return false;
        } else {
            userStorage.save(user);
            return true;
        }
    }

    public User findByUsername(String username) {
        if (userStorage.existByUsername(username)) {
            return userStorage.getByUsername(username);
        }
        return null;
    }
}
