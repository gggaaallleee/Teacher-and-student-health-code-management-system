package main.Dao;

import main.models.CClass;
import java.util.List;

public interface class_manage  extends BaseDao{
    void addClass(CClass cClass);
    void updateClass(CClass cClass);
    void deleteClass(String id);
    void batchAddClass(List<CClass> cClass);

    List<CClass> findClass(String way,String thing);

    List<CClass> findAllClass();

}
