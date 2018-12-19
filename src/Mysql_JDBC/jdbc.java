package Mysql_JDBC;
import java.sql.*;

/**
 * @author Dgd
 * @create 2017-10-16-21:25
 * 测试数据库
 */
public class jdbc {
        //mysql驱动包名
        private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
        //数据库连接地址
        private static final String URL = "jdbc:mysql://localhost:3306/database00?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
        //用户名
        private static final String USER_NAME = "taylor";
        //密码
        private static final String PASSWORD = "taylor";
        public static void main(String[] args){
                Connection conn = null;
                try {
                        //加载mysql的驱动类
                        Class.forName(DRIVER_NAME);
                        //获取数据库连接
                        conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                        //mysql查询语句
                        String sql = "SELECT img FROM image";
                        PreparedStatement prst = conn.prepareStatement(sql);
                        //结果集
                        ResultSet rs = prst.executeQuery();
                        while (rs.next()) {
                                System.out.println("用户名:" + rs.getString("img"));
                        }
                        rs.close();
                        prst.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }finally {
                        if (conn != null) {
                                try {
                                        conn.close();
                                } catch (SQLException e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }
}

