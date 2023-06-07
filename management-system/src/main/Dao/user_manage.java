package main.Dao;
import main.models.User;
import java.util.List;

public interface user_manage  extends BaseDao{
    void addUser(User user);
    void batchAddUser(List<User> users);
    void updateUser(User user);
    void deleteUser(String username);
    List<User> findUser(String way,String thing);
    List<User> findAllUser();
}
