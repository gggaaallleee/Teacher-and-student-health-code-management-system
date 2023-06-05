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
        //int id, String name, String idCard, String workNo, String college, String role, String healthCode, boolean dailycheck
        String sql = "INSERT INTO Teacher(id,name,idCard,workNo,college,role,healthCode,dailycheck) VALUES(?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,teacher.getId());
            pstmt.setString(2,teacher.getName());
            pstmt.setString(3,teacher.getIdCard());
            pstmt.setString(4,teacher.getWorkNo());
            pstmt.setString(5,teacher.getCollege());
            pstmt.setString(6,teacher.getRole());
            pstmt.setString(7,teacher.getHealthCode());
            pstmt.setString(8,teacher.isDailycheck());
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
    public void batchAddTeacher(List<Teacher> teachers){
        //addTeacher是单个添加，这里是批量添加，用list
        String sql = "INSERT INTO Teacher(id,name,idCard,workNo,college,role,healthCode,dailycheck) VALUES(?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (Teacher t : teachers) {
                pstmt.setString(1,t.getId());
                pstmt.setString(2,t.getName());
                pstmt.setString(3,t.getIdCard());
                pstmt.setString(4,t.getWorkNo());
                pstmt.setString(5,t.getCollege());
                pstmt.setString(6,t.getRole());
                pstmt.setString(7,t.getHealthCode());
                pstmt.setString(8,t.isDailycheck());
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
    public void updateTeacher(Teacher teacher){
        String sql = "UPDATE Teacher SET name=?,idCard=?,workNo=?,college=?,role=?,healthCode=?,dailycheck=? WHERE id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,teacher.getName());
            pstmt.setString(2,teacher.getIdCard());
            pstmt.setString(3,teacher.getWorkNo());
            pstmt.setString(4,teacher.getCollege());
            pstmt.setString(5,teacher.getRole());
            pstmt.setString(6,teacher.getHealthCode());
            pstmt.setString(7,teacher.isDailycheck());
            pstmt.setString(8,teacher.getId());
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
    public void deleteTeacher(String id){
        String sql = "DELETE FROM Teacher WHERE id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
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
    public List<Teacher> findTeacher(String way,String thing){
        String sql = "SELECT * FROM Teacher WHERE "+way+"=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Teacher> teachers = new ArrayList<Teacher>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,thing);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setName(rs.getString("name"));
                teacher.setIdCard(rs.getString("idCard"));
                teacher.setWorkNo(rs.getString("workNo"));
                teacher.setCollege(rs.getString("college"));
                teacher.setRole(rs.getString("role"));
                teacher.setHealthCode(rs.getString("healthCode"));
                teacher.setDailycheck(rs.getString("dailycheck"));
                teachers.add(teacher);
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
                teacher.setId(rs.getString("id"));
                teacher.setName(rs.getString("name"));
                teacher.setIdCard(rs.getString("idCard"));
                teacher.setWorkNo(rs.getString("workNo"));
                teacher.setCollege(rs.getString("college"));
                teacher.setRole(rs.getString("role"));
                teacher.setHealthCode(rs.getString("healthCode"));
                teacher.setDailycheck(rs.getString("dailycheck"));
                teachers.add(teacher);
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
        return teachers;
    }

}
