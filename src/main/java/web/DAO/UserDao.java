package web.DAO;

import web.Model.User;

import java.util.List;

public interface UserDao {
    void saveUser(String firstName, String lastName, String email);

    User showUserById(int id);

    List<User> getAllUsers();

    void updateUserById(int id, User user);

    void removeUserById(int id);
}
