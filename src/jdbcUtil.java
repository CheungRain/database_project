import java.sql.*;
public class jdbcUtil {
    /*
     * jdbc:mysql:  是指JDBC连接方式；
     *127.0.0.1:       是指你的本机地址；
     * 3306               SQL数据库的端口号；
     * mysql              就是你要连接的数据库的名字。
     * characterEncoding     指定数据库连接的编码方式
     * com.mysql.jdbc.Driver  注册数据库驱动 过时
     * com.mysql.cj.jdbc.Driver  新的数据库驱动
     */
    public static Connection openConnection() {
        //mysql 连接url
        String url = "jdbc:mysql://localhost:3306/homework";
        //数据库用户名
        String userName = "root";
        //数据库密码
        String passWord = "111111";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //注册数据库驱动
            Connection conn = DriverManager.getConnection(url, userName, passWord); //获取数据连接
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
