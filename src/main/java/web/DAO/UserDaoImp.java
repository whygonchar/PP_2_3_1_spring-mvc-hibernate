package web.DAO;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveUser(String firstName, String lastName, String email) {
        entityManager.persist(new User(firstName, lastName, email));
    }

    @Override
    @Transactional(readOnly = true)
    public User showUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void updateUserById(int id, User user) {
        User userUpdated = entityManager.find(User.class, id);
        userUpdated.setFirstName(user.getFirstName());
        userUpdated.setLastName(user.getLastName());
        userUpdated.setEmail(user.getEmail());
    }

    @Override
    @Transactional
    public void removeUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
