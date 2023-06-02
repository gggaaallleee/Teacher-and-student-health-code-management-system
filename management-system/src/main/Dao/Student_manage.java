package main.Dao;

import main.models.Student;

import java.util.List;

public interface Student_manage  extends BaseDao{
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(String id);
    List<Student> findStudent(String way,String thing);
    List<Student> findAllStudent();
    void batchAddStudent(List<Student> students);
}
