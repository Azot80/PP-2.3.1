package azot.webcrud.app.dao;

import azot.webcrud.app.models.User;

import java.util.List;

public interface UserDAO {
    public List<User> getUsersList();

    public void saveUser(User user);

    public User getUser(long id);

    public void updateUser(long id, User user);

    public void deleteUserByID(long id);
}
