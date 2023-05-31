package main.Dao;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
public interface BaseDao {
    //查找并返回数据源对象
    static DataSource getDataSource() {
        DataSource dataSource;
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/myDataSource");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }

    //返回连接对象方法
    default Connection getConnection() {
        DataSource dataSource = getDataSource();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
