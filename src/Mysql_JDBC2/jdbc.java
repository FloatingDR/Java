package Mysql_JDBC2;
import java.sql.*;
public class jdbc {
    static  final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/database00?serverTimezone=GMT%2B8";

    static final String USER="taylor";
    static final String PASS="taylor";

    public static void main(String[]args){
        Connection conn=null;
        Statement stmt=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connecting to database....");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating statement....");
            stmt=conn.createStatement();
            String sql;
            sql="SELECT img,path FROM image";
            ResultSet rs =stmt.executeQuery(sql);
            while(rs.next()){
                String img=rs.getString("img");
                String path=rs.getString("path");
                System.out.print("IMG: "+img);
                System.out.println(", PATH: "+path);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
                //nothing we can do
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
