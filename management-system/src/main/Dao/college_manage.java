package main.Dao;
import java.util.List;

import main.models.Major;
import main.models.College;
public interface college_manage    extends BaseDao{
    //String id, String name
    /*    void addMajor(Major major);
    void updateMajor(Major major);
    void deleteMajor(String id);
    void batchAddMajor(List<Major> major);

    List<Major> findMajor(String way,String thing);

    List<Major> findAllMajor();
*/
    void addCollege(College college);
    void updateCollege(College college);
    void deleteCollege(String id);
    void batchAddCollege(List<College> college);

    List<College> findCollege(String way,String thing);

    List<College> findAllCollege();







}
