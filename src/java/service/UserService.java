package service;

import dao.UserDao;
import entities.User;

public class UserService {

    private final UserDao userDao = new UserDao();

    public User login(String email, String password) {
        return userDao.connecter(email, password);
    }
}
