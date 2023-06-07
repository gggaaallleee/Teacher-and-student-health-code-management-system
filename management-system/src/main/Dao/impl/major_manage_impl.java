package main.Dao.impl;
import main.Dao.major_manage;
import main.models.Major;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class major_manage_impl implements main.Dao.major_manage{
    //String id, String name, String college

    @Override
    public void addMajor(Major major){
        String sql = "INSERT INTO Major(name,college) VALUES(?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,major.getName());
            pstmt.setString(2,major.getCollege());
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
    public void updateMajor(Major major){
        String sql = "UPDATE Major SET college=? WHERE name=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            /*
            pstmt.setString(3,major.getId());
            pstmt.setString(1,major.getName());
            pstmt.setString(2,major.getCollege());*/
                pstmt.setString(2,major.getName());
                pstmt.setString(1,major.getCollege());
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
    public void deleteMajor(String name){
        String sql = "DELETE FROM Major WHERE name=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
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
    public void batchAddMajor( List<Major> major){
        String sql = "INSERT INTO Major(name,college) VALUES(?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (Major c: major) {
                pstmt.setString(1,c.getName());
                pstmt.setString(2,c.getCollege());
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
    public List<Major> findMajor(String way,String thing){
        String sql = "SELECT * FROM Major WHERE "+way+"=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Major> majors = new ArrayList<>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            String pattern = "%" + thing + "%";
            pstmt.setString(1, pattern);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Major major = new Major();
                major.setName(rs.getString("name"));
                major.setCollege(rs.getString("college"));
                majors.add(major);
            }
            return majors;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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
    }
    @Override
    public List<Major> findAllMajor(){
        String sql = "SELECT * FROM Major";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Major> majors = new ArrayList<>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Major major = new Major();
                major.setName(rs.getString("name"));
                major.setCollege(rs.getString("college"));
                majors.add(major);
            }
            return majors;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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
    }
}
