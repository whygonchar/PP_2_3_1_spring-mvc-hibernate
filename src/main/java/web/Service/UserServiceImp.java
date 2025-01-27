package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.DAO.UserDao;
import web.Model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(String firstName, String lastName, String email) {
        userDao.saveUser(firstName, lastName, email);
    }

    @Override
    public User showUserById(int id) {
        return userDao.showUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUserById(int id, User user) {
        userDao.updateUserById(id, user);
    }

    @Override
    public void removeUserById(int id) {
        userDao.removeUserById(id);
    }
}

