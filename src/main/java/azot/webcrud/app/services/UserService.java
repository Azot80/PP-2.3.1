package azot.webcrud.app.services;

import azot.webcrud.app.models.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();

    public void saveUser(User user);

    public User getUserById(long id);

    public void update(long id, User user);

    public void deleteUser(long id);
}
