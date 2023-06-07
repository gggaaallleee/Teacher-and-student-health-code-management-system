package main.Dao;
import main.models.Teacher;

import java.util.List;

public interface  Teacher_manage extends BaseDao{
    void addTeacher(Teacher teacher);
    void batchAddTeacher(List<Teacher> teachers);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(String workNo);
    List<Teacher> findTeacher(String way,String thing);
    List<Teacher> findAllTeacher();
}
