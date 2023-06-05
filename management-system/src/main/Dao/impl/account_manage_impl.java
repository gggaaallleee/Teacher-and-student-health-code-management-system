package main.Dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.models.account;
public class account_manage_impl  implements main.Dao.account_manage {
    //String id, String workNo, String pwd, String role

    @Override
    public void addAccount(account account) {

        String sql = "INSERT INTO account(id,workNo,pwd,role) VALUES(?,?,?,?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account.getId());
            pstmt.setString(2, account.getWorkNo());
            pstmt.setString(3, account.getPwd());
            pstmt.setString(4, account.getRole());
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
    public void batchAddAccount(List<account> accounts) {
        String sql = "INSERT INTO account(id,workNo,pwd,role) VALUES(?,?,?,?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (account a : accounts) {
                pstmt.setString(1, a.getId());
                pstmt.setString(2, a.getWorkNo());
                pstmt.setString(3, a.getPwd());
                pstmt.setString(4, a.getRole());
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
    public void updateAccount(account account){
        String sql = "UPDATE account SET workNo=?,pwd=?,role=? WHERE id=?";
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,account.getWorkNo());
            pstmt.setString(2,account.getPwd());
            pstmt.setString(3,account.getRole());
            pstmt.setString(4,account.getId());
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
    public void deleteAccount(String id){
        String sql = "DELETE FROM account WHERE id=?";
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        try{
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
    public List<account> findAccount(String way,String thing){
        String sql = "SELECT * FROM account WHERE ?=?";
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<account> accounts = new ArrayList<account>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,way);
            pstmt.setString(2,thing);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                account account = new account();
                account.setId(rs.getString("id"));
                account.setWorkNo(rs.getString("workNo"));
                account.setPwd(rs.getString("pwd"));
                account.setRole(rs.getString("role"));
                accounts.add(account);
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
        return accounts;
    }
    @Override
    public List<account> findAllAccount(){
        String sql = "SELECT * FROM account";
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<account> accounts = new ArrayList<account>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                account account = new account();
                account.setId(rs.getString("id"));
                account.setWorkNo(rs.getString("workNo"));
                account.setPwd(rs.getString("pwd"));
                account.setRole(rs.getString("role"));
                accounts.add(account);
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
        return accounts;
    }
}
