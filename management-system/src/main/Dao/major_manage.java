package main.Dao;

import java.util.List;
import main.models.Major;
public interface major_manage  extends BaseDao{
    void addMajor(Major major);
    void updateMajor(Major major);
    void deleteMajor(String name);
    void batchAddMajor(List<Major> major);

    List<Major> findMajor(String way,String thing);

    List<Major> findAllMajor();

}

