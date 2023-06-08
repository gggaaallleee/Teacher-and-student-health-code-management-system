package main.Dao.impl;
import main.Dao.BaseDao;
import main.Dao.college_manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.models.College;
public class college_manage_impl  implements college_manage{
    //String id, String name
    /*    public void addCollege(College college);
    public void updateCollege(College college);
    public void deleteCollege(String id);
    public List<College> getAllCollege();
    public College getCollegeById(String id);
    public List<Major> getMajorByCollege(String college);*/
    @Override
    public void addCollege(College college){
        String sql = "INSERT INTO College(id,name) VALUES(?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,college.getId());
            pstmt.setString(2,college.getName());
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
    public void updateCollege(College college){
        String sql = "UPDATE College SET name=? WHERE id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
                pstmt.setString(2,college.getId());
                pstmt.setString(1,college.getName());
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

    public  void deleteCollege(String id){
        String sql = "DELETE FROM College WHERE id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
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
    public void batchAddCollege(List<College> college){
        String sql = "INSERT INTO College(id,name) VALUES(?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for(int i=0;i<college.size();i++){
                pstmt.setString(1,college.get(i).getId());
                pstmt.setString(2,college.get(i).getName());
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
    public List<College> findCollege(String way,String thing){
        String sql = "SELECT * FROM College WHERE "+way+"=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<College> college = new ArrayList<College>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            String pattern = "%" + thing + "%";
            pstmt.setString(1, pattern);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                College temp = new College();
                temp.setId(rs.getString("id"));
                temp.setName(rs.getString("name"));
                college.add(temp);
            }
            return college;
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
    }
    @Override
    public List<College> findAllCollege(){
        String sql = "SELECT * FROM College";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<College> college = new ArrayList<College>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                College temp = new College();
                temp.setId(rs.getString("id"));
                temp.setName(rs.getString("name"));
                college.add(temp);
            }
            return college;
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
    }
}
