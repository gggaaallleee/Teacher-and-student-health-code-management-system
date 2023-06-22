package main.Dao.impl;
import com.alibaba.fastjson.JSON;
import main.models.Student;
import main.models.respond_json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student_manage_impl implements main.Dao.Student_manage{
    @Override
    public void addStudent(Student student) {
        //int id,String name, String idCard, String studentNo, String college, String major, String classNo, String healthCode, boolean dailycheck,int checkdays
        String sql = "INSERT INTO Student(name,idCard,studentNo,college,major,classNo,healthCode,dailycheck,checkdays) VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getIdCard());
            pstmt.setString(3, student.getStudentNo());
            pstmt.setString(4, student.getCollege());
            pstmt.setString(5, student.getMajor());
            pstmt.setString(6, student.getClassNo());
            pstmt.setString(7, student.getHealthCode());
            pstmt.setString(8, student.isDailycheck());
            pstmt.setInt(9, student.getCheckdays());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            
                e.printStackTrace();
                throw new RuntimeException(e);
        } finally {
            // 关闭资源
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }


        @Override
        public void batchAddStudent(List<Student> students){
            //addStudent是单个添加，这里是批量添加，用list
            String sql = "INSERT INTO Student(name,idCard,studentNo,college,major,classNo,healthCode,dailycheck,checkdays) VALUES(?,?,?,?,?,?,?,?,?)";
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                for (Student s : students) {
                    pstmt.setString(1, s.getName());
                    pstmt.setString(2, s.getIdCard());
                    pstmt.setString(3, s.getStudentNo());
                    pstmt.setString(4, s.getCollege());
                    pstmt.setString(5, s.getMajor());
                    pstmt.setString(6, s.getClassNo());
                    pstmt.setString(7, s.getHealthCode());
                    pstmt.setString(8, s.isDailycheck());
                    pstmt.setInt(9, s.getCheckdays());
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
            } catch (SQLException e) {
                
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                // 关闭资源
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                
                e.printStackTrace();
                throw new RuntimeException(e);
                }
            }
        }

        @Override
        public void deleteStudent(String workNo){
            String sql = "DELETE FROM Student WHERE studentno = ?";
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,workNo);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                // 关闭资源
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                
                e.printStackTrace();
                throw new RuntimeException(e);
                }
            }
        }

        @Override
        public void updateStudent(Student student){
            String sql = "UPDATE Student SET idCard = ?,name = ?,college = ?,major = ?,classNo = ?,healthCode = ?,dailycheck = ? , checkdays = ? WHERE studentNo = ?";
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                    pstmt.setString(9, student.getStudentNo());
                    pstmt.setString(1, student.getIdCard());
                    pstmt.setString(2, student.getName());
                    pstmt.setString(3, student.getCollege());
                    pstmt.setString(4, student.getMajor());
                    pstmt.setString(5, student.getClassNo());
                    pstmt.setString(6, student.getHealthCode());
                    pstmt.setString(7, student.isDailycheck());
                    pstmt.setInt(8, student.getCheckdays());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("更新数据失败");
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                // 关闭资源
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                
                e.printStackTrace();
                throw new RuntimeException(e);
                }
            }
        }

        @Override
        public List<Student> findStudent(String way,String thing) {
            String sql = "SELECT * FROM Student WHERE " + way + "=?";
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            List<Student> students = new ArrayList<Student>();
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                String pattern =  thing ;
                pstmt.setString(1, pattern);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setName(rs.getString("name"));
                    student.setIdCard(rs.getString("idCard"));
                    student.setStudentNo(rs.getString("studentNo"));
                    student.setCollege(rs.getString("college"));
                    student.setMajor(rs.getString("major"));
                    student.setClassNo(rs.getString("classNo"));
                    student.setHealthCode(rs.getString("healthCode"));
                    student.setDailycheck(rs.getString("dailycheck"));
                    student.setCheckdays(rs.getInt("checkdays"));
                    students.add(student);
                }

            } catch (SQLException e) {
                
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                // 关闭资源
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    
                e.printStackTrace();
                throw new RuntimeException(e);
                }
            }
            return students;
        }
        @Override
        public List<Student> findAllStudent() {
            String sql = "SELECT * FROM Student";
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            List<Student> students = new ArrayList<Student>();
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setName(rs.getString("name"));
                    student.setIdCard(rs.getString("idCard"));
                    student.setStudentNo(rs.getString("studentNo"));
                    student.setCollege(rs.getString("college"));
                    student.setMajor(rs.getString("major"));
                    student.setClassNo(rs.getString("classNo"));
                    student.setHealthCode(rs.getString("healthCode"));
                    student.setDailycheck(rs.getString("dailycheck"));
                    student.setCheckdays(rs.getInt("checkdays"));
                    students.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                // 关闭资源
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
                }
            }
            return students;
        }


}
