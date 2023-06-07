package main.Dao.impl;
import main.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class user_manage_impl implements main.Dao.user_manage{
    //String id, String username, String password, int level
    /*void addUser(User user);
    void batchAddUser(List<User> users);
    void updateUser(User user);
    void deleteUser(String id);
    List<User> findUser(String way,String thing);
    List<User> findAllUser();*/

    @Override
    public void addUser(User user){
        String sql = "INSERT INTO User(username,password,level) VALUES(?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setInt(3,user.getLevel());
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
    public void batchAddUser(List<User> users){
        String sql = "INSERT INTO User(username,password,level) VALUES(?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (User u : users) {
                pstmt.setString(1,u.getUsername());
                pstmt.setString(2,u.getPassword());
                pstmt.setInt(3,u.getLevel());
                pstmt.executeUpdate();
            }
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
    public void updateUser(User user){
        String sql = "UPDATE User SET password=?,level=? WHERE username=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(3,user.getUsername());
            pstmt.setString(1,user.getPassword());
            pstmt.setInt(2,user.getLevel());
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
    public void deleteUser(String username){
        String sql = "DELETE FROM User WHERE username=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
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
    public List<User> findUser(String way,String thing) {
        String sql = "SELECT * FROM User WHERE " + way + "=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            String pattern = "%" + thing + "%";
            pstmt.setString(1, pattern);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setLevel(rs.getInt("level"));
                users.add(user);
            }
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
        return users;
    }

    @Override
    public List<User> findAllUser(){
        String sql = "SELECT * FROM User";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setLevel(rs.getInt("level"));
                users.add(user);
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
        }return users;
    }

}
