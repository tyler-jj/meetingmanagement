package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDruidUtils {

    //定义连接池对象
    private static DataSource ds;
    static {
        try {
            //加载配置文件
            Properties pro= new Properties();
            pro.load(JdbcDruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取datasource
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     * @param rs
     */
    public static void close(Statement stmt , Connection conn, ResultSet rs){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 重载释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt , Connection conn){
        close(stmt,conn,null);
    }

    public static DataSource getDatasource(){
        return ds;
    }




}
