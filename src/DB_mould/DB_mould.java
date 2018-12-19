package DB_mould;

import java.sql.*;

public class DB_mould {
    Connection con = null;

    //建立连接
    public void coon() {
        try {
            String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/database00?serverTimezone=GMT%2B8";
            String USER = "taylor";
            String PASS = "taylor";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭连接
    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询执行select语句
    public ResultSet getRS(String sql) throws SQLException {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    //执行Update,Delete,Insert语句
    public int exec(String sql) throws SQLException {

        Statement st = con.createStatement();
        int a = st.executeUpdate(sql);
        return a;
    }
}
