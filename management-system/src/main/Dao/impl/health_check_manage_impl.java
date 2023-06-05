package main.Dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.Dao.health_check_manage;
import main.models.health_check;

public class health_check_manage_impl  implements main.Dao.health_check_manage{
    //String name, String id, String number, String phone, String is_in_danger, String is_abroad, String is_contact, String is_confirmed, String vaccine, String health_status
    @Override
    public void addhealth_check(health_check health_check){
        String sql = "INSERT INTO health_check(name,id,number,phone,is_in_danger,is_abroad,is_contact,is_confirmed,vaccine,health_status) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,health_check.getName());
            pstmt.setString(2,health_check.getId());
            pstmt.setString(3,health_check.getNumber());
            pstmt.setString(4,health_check.getPhone());
            pstmt.setString(5,health_check.getIs_in_danger());
            pstmt.setString(6,health_check.getIs_abroad());
            pstmt.setString(7,health_check.getIs_contact());
            pstmt.setString(8,health_check.getIs_confirmed());
            pstmt.setString(9,health_check.getVaccine());
            pstmt.setString(10,health_check.getHealth_status());
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
    public void updatehealth_check(health_check health_check){
        String sql = "UPDATE health_check SET name=?,id=?,number=?,phone=?,is_in_danger=?,is_abroad=?,is_contact=?,is_confirmed=?,vaccine=?,health_status=? WHERE number=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,health_check.getName());
            pstmt.setString(2,health_check.getId());
            pstmt.setString(3,health_check.getNumber());
            pstmt.setString(4,health_check.getPhone());
            pstmt.setString(5,health_check.getIs_in_danger());
            pstmt.setString(6,health_check.getIs_abroad());
            pstmt.setString(7,health_check.getIs_contact());
            pstmt.setString(8,health_check.getIs_confirmed());
            pstmt.setString(9,health_check.getVaccine());
            pstmt.setString(10,health_check.getHealth_status());
            pstmt.setString(11,health_check.getNumber());
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
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public void deletehealth_check(String number){
        String sql = "DELETE FROM health_check WHERE number=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,number);
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
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public void batchAddhealth_check(List<health_check> health_check){
        String sql = "INSERT INTO health_check(name,id,number,phone,is_in_danger,is_abroad,is_contact,is_confirmed,vaccine,health_status) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for(int i=0;i<health_check.size();i++){
                pstmt.setString(1,health_check.get(i).getName());
                pstmt.setString(2,health_check.get(i).getId());
                pstmt.setString(3,health_check.get(i).getNumber());
                pstmt.setString(4,health_check.get(i).getPhone());
                pstmt.setString(5,health_check.get(i).getIs_in_danger());
                pstmt.setString(6,health_check.get(i).getIs_abroad());
                pstmt.setString(7,health_check.get(i).getIs_contact());
                pstmt.setString(8,health_check.get(i).getIs_confirmed());
                pstmt.setString(9,health_check.get(i).getVaccine());
                pstmt.setString(10,health_check.get(i).getHealth_status());
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

            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    @Override

    public  List<health_check> findhealth_check(String way,String thing){
        String sql = "SELECT * FROM health_check WHERE ?=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<health_check> health_check = new ArrayList<health_check>();
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,way);
            pstmt.setString(2,thing);
            rs = pstmt.executeQuery();
            while(rs.next()){
                health_check health_check1 = new health_check();
                health_check1.setName(rs.getString("name"));
                health_check1.setId(rs.getString("id"));
                health_check1.setNumber(rs.getString("number"));
                health_check1.setPhone(rs.getString("phone"));
                health_check1.setIs_in_danger(rs.getString("is_in_danger"));
                health_check1.setIs_abroad(rs.getString("is_abroad"));
                health_check1.setIs_contact(rs.getString("is_contact"));
                health_check1.setIs_confirmed(rs.getString("is_confirmed"));
                health_check1.setVaccine(rs.getString("vaccine"));
                health_check1.setHealth_status(rs.getString("health_status"));
                health_check.add(health_check1);
            }
            return health_check;
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
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override

    public  List<health_check> findAllhealth_check(){
        String sql = "SELECT * FROM health_check";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<health_check> health_check = new ArrayList<health_check>();
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                health_check health_check1 = new health_check();
                health_check1.setName(rs.getString("name"));
                health_check1.setId(rs.getString("id"));
                health_check1.setNumber(rs.getString("number"));
                health_check1.setPhone(rs.getString("phone"));
                health_check1.setIs_in_danger(rs.getString("is_in_danger"));
                health_check1.setIs_abroad(rs.getString("is_abroad"));
                health_check1.setIs_contact(rs.getString("is_contact"));
                health_check1.setIs_confirmed(rs.getString("is_confirmed"));
                health_check1.setVaccine(rs.getString("vaccine"));
                health_check1.setHealth_status(rs.getString("health_status"));
                health_check.add(health_check1);
            }
            return health_check;
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
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
