package main.Dao.impl;
import main.models.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Teacher_manage_impl implements main.Dao.Teacher_manage{
    @Override
    public void addTeacher(Teacher teacher){
        //int id, String name, String idCard, String workNo, String college, String role, String healthCode, boolean dailycheck,int checkdays
        String sql = "INSERT INTO Teacher(name,idCard,workNo,college,healthCode,dailycheck,checkdays) VALUES(?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,teacher.getName());
            pstmt.setString(2,teacher.getIdCard());
            pstmt.setString(3,teacher.getWorkNo());
            pstmt.setString(4,teacher.getCollege());
            pstmt.setString(5,teacher.getHealthCode());
            pstmt.setString(6,teacher.isDailycheck());
            pstmt.setInt(7,teacher.getCheckdays());
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
    public void batchAddTeacher(List<Teacher> teachers){
        //addTeacher是单个添加，这里是批量添加，用list
        String sql = "INSERT INTO Teacher(name,idCard,workNo,college,healthCode,dailycheck,checkdays) VALUES(?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (Teacher t : teachers) {
                pstmt.setString(1,t.getName());
                pstmt.setString(2,t.getIdCard());
                pstmt.setString(3,t.getWorkNo());
                pstmt.setString(4,t.getCollege());
                pstmt.setString(5,t.getHealthCode());
                pstmt.setString(6,t.isDailycheck());
                pstmt.setInt(7,t.getCheckdays());
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
    public void updateTeacher(Teacher teacher){
        String sql = "UPDATE Teacher SET idCard=?,name=?,college=?,healthCode=?,dailycheck=? ,checkdays = ? WHERE workNo=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(7,teacher.getWorkNo());
            pstmt.setString(1,teacher.getIdCard());
            pstmt.setString(2,teacher.getName());
            pstmt.setString(3,teacher.getCollege());
            pstmt.setString(4,teacher.getHealthCode());
            pstmt.setString(5,teacher.isDailycheck());
            pstmt.setInt(6,teacher.getCheckdays());
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
    public void deleteTeacher(String workNo){
        String sql = "DELETE FROM Teacher WHERE workNo=?";
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
    public List<Teacher> findTeacher(String way,String thing){
        String sql = "SELECT * FROM Teacher WHERE "+way+"=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Teacher> teachers = new ArrayList<Teacher>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            String pattern = "%" + thing + "%";
            pstmt.setString(1, pattern);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setName(rs.getString("name"));
                teacher.setIdCard(rs.getString("idCard"));
                teacher.setWorkNo(rs.getString("workNo"));
                teacher.setCollege(rs.getString("college"));
                teacher.setHealthCode(rs.getString("healthCode"));
                teacher.setDailycheck(rs.getString("dailycheck"));
                teacher.setCheckdays(rs.getInt("checkdays"));
                teachers.add(teacher);
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
        return teachers;
    }

    @Override
    public List<Teacher> findAllTeacher(){
        String sql = "SELECT * FROM Teacher";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Teacher> teachers = new ArrayList<Teacher>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setName(rs.getString("name"));
                teacher.setIdCard(rs.getString("idCard"));
                teacher.setWorkNo(rs.getString("workNo"));
                teacher.setCollege(rs.getString("college"));
                teacher.setHealthCode(rs.getString("healthCode"));
                teacher.setDailycheck(rs.getString("dailycheck"));
                teacher.setCheckdays(rs.getInt("checkdays"));
                teachers.add(teacher);
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
        return teachers;
    }

}
