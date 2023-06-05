package main.Dao;
import java.util.List;
import main.models.account;
public interface account_manage  extends BaseDao{
    void addAccount(account account);
    void batchAddAccount(List<account> accounts);
    void updateAccount(account account);
    void deleteAccount(String id);
    List<account> findAccount(String way,String thing);
    List<account> findAllAccount();
}
