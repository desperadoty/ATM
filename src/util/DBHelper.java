package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2017/3/2.
 */
public class DBHelper {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/bank?useUnicode=true&useSSL=false&characterEncoding=UTF-8";
    private static final String username = "root";
    private static final String password = "desperadoty";
    private static Connection conn = null;

    //静态代码块加载驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //单例模式返回数据库连接对象
    public static Connection  getConn() throws Exception{
        if(conn == null) {
            conn = DriverManager.getConnection(url,username,password);
            return conn;
        }
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection conn = DBHelper.getConn();
            if(conn != null) {
                System.out.println("数据库连接成功!");
            } else {
                System.out.println("数据库连接失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
