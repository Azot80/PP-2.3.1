package azot.webcrud.app.services;

import azot.webcrud.app.dao.UserDAO;
import azot.webcrud.app.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsersList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void update(long id, User user) {
        userDAO.updateUser(id, user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userDAO.deleteUserByID(id);
    }
}
