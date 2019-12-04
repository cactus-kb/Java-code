import java.math.BigDecimal;
import java.sql.*;

public class DButil {
    /*MySQL数据连接的URL参数格式如下：
      jdbc:mysql://服务器地址:端口/数据库名
    */
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    //自己的账号
    private static final String USERNAME = "root";
    //自己的密码
    private static final String PASSWORD = "1111";
    public static void main(String[] args)  {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //加载JDBC驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //创建数据库连接
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //打印连接，打印内容不为空，则连接正常；打印内容为空或报异常，则连接不正常
            System.out.println(connection);
            //创建操作命令
            statement = connection.createStatement();
            //执行SQL,获取到返回结果
            String sql = " select id,name,chinese,math,english from exam_result";
            resultSet = statement.executeQuery(sql);
            //处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                BigDecimal chinese = resultSet.getBigDecimal("chinese");
                BigDecimal math = resultSet.getBigDecimal("math");
                BigDecimal english = resultSet.getBigDecimal("english");
                System.out.printf("id = %s, name = %s, chinese = %s, math = %s, english = %s",id,name,chinese,math,english);
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源，要倒序释放
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
