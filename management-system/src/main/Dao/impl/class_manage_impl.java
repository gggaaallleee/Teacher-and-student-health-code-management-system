package main.Dao.impl;

import main.Dao.class_manage;

import main.models.CClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class class_manage_impl implements main.Dao.class_manage{

    @Override
    public void addClass(CClass cClass){
        //String id, String name, String studentNo,String Cmajor
        String sql = "INSERT INTO Class(id,name,studentNo,Cmajor) VALUES(?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,cClass.getId());
            pstmt.setString(2,cClass.getName());
            pstmt.setString(3,cClass.getStudentNo());
            pstmt.setString(4,cClass.getCmajor());
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
    public void batchAddClass( List<CClass> cClass){
        String sql = "INSERT INTO Class(id,name,studentNo,Cmajor) VALUES(?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (CClass c: cClass) {
                pstmt.setString(1,c.getId());
                pstmt.setString(2,c.getName());
                pstmt.setString(3,c.getStudentNo());
                pstmt.setString(4,c.getCmajor());
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
    public void deleteClass(String id) {
        String sql = "DELETE FROM Class WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
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
    public void updateClass(CClass cClass) {
        String sql = "UPDATE Class SET name = ?,studentNo = ? ,Cmajor = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cClass.getName());
            pstmt.setString(2, cClass.getStudentNo());
            pstmt.setString(3, cClass.getCmajor());
            pstmt.setString(4, cClass.getId());

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
    public List<CClass> findClass(String way,String thing){
        String sql = "SELECT * FROM Class WHERE "+way+" = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<CClass> cClassList = new ArrayList<>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, thing);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CClass cClass = new CClass();
                cClass.setId(rs.getString("id"));
                cClass.setName(rs.getString("name"));
                cClass.setStudentNo(rs.getString("studentNo"));
                cClass.setCmajor(rs.getString("Cmajor"));
                cClassList.add(cClass);
            }
            return cClassList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null){
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public List<CClass> findAllClass(){
        String sql = "SELECT * FROM Class";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<CClass> cClassList = new ArrayList<>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CClass cClass = new CClass();
                cClass.setId(rs.getString("id"));
                cClass.setName(rs.getString("name"));
                cClass.setStudentNo(rs.getString("studentNo"));
                cClass.setCmajor(rs.getString("Cmajor"));
                cClassList.add(cClass);
            }
            return cClassList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null){
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


}
