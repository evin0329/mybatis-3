package mybatisdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class JdbcTest {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";
    private Connection connection;

    @Before
    public void init() throws SQLException {
        // 第一步 获取连接
         connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @After
    public void over() throws SQLException {
        connection.close();
    }

    @Test
    public void jdbcTest() throws SQLException {
        // 第二步  预编译  & 设置参数 
        String sql = "SELECT * FROM users WHERE `name`=?";
        PreparedStatement sql1 = connection.prepareStatement(sql);
        sql1.setString(1,"aaa");
        // 第三步 执行SQL
        sql1.execute();
        // 第四步 获取返回结果
        ResultSet resultSet = sql1.getResultSet();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(3));
        }
        resultSet.close();
        sql1.close();;
    }
    
}
