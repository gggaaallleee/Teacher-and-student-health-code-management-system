package main.Dao;
import java.util.List;
import main.models.health_check;
public interface health_check_manage extends BaseDao{
    void addhealth_check(health_check health_check);
    void updatehealth_check(health_check health_check);
    void deletehealth_check(String number);
    void batchAddhealth_check(List<health_check> health_check);

    List<health_check> findhealth_check(String way,String thing);

    List<health_check> findAllhealth_check();
}
