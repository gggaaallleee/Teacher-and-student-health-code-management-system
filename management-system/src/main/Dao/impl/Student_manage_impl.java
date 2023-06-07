package main.Dao.impl;
import main.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student_manage_impl implements main.Dao.Student_manage{
    @Override
    public void addStudent(Student student) {
        //int id,String name, String idCard, String studentNo, String college, String major, String classNo, String healthCode, boolean dailycheck
        String sql = "INSERT INTO Student(name,idCard,studentNo,college,major,classNo,healthCode,dailycheck) VALUES(?,?,?,?,?,?,?,?)";
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
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
            }
        }
    }


        @Override
        public void batchAddStudent(List<Student> students){
            //addStudent是单个添加，这里是批量添加，用list
            String sql = "INSERT INTO Student(name,idCard,studentNo,college,major,classNo,healthCode,dailycheck) VALUES(?,?,?,?,?,?,?,?)";
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
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
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
                }
            }
        }

        @Override
        public void deleteStudent(String workNo){
            String sql = "DELETE FROM Student WHERE workNo = ?";
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,workNo);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
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
                }
            }
        }

        @Override
        public void updateStudent(Student student){
            String sql = "UPDATE Student SET idCard = ?,studentNo = ?,college = ?,major = ?,classNo = ?,healthCode = ?,dailycheck = ? WHERE name = ?";
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                /*
                pstmt.setString(1, student.getName());
                pstmt.setString(2, student.getIdCard());
                pstmt.setString(3, student.getStudentNo());
                pstmt.setString(4, student.getCollege());
                pstmt.setString(5, student.getMajor());
                pstmt.setString(6, student.getClassNo());
                pstmt.setString(7, student.getHealthCode());
                pstmt.setString(8, student.isDailycheck());
                pstmt.setString(9, student.getId());*/
                    pstmt.setString(8, student.getName());
                    pstmt.setString(1, student.getIdCard());
                    pstmt.setString(2, student.getStudentNo());
                    pstmt.setString(3, student.getCollege());
                    pstmt.setString(4, student.getMajor());
                    pstmt.setString(5, student.getClassNo());
                    pstmt.setString(6, student.getHealthCode());
                    pstmt.setString(7, student.isDailycheck());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
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
                }
            }
        }

        @Override
        public List<Student> findStudent(String way,String thing) {
            String sql = "SELECT * FROM Teacher WHERE " + way + "=?";
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            List<Student> students = new ArrayList<Student>();
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                String pattern = "%" + thing + "%";
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
                    students.add(student);
                }

            } catch (SQLException e) {
                e.printStackTrace();
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
                    students.add(student);
                }

            } catch (SQLException e) {
                e.printStackTrace();
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
                }
            }
            return students;
        }


}
