import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;

public class DButil2 {
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
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            try {
                //获取到数据库池
                DataSource ds = new MysqlDataSource();
                ((MysqlDataSource) ds).setURL(URL);
                ((MysqlDataSource) ds).setUser(USERNAME);
                ((MysqlDataSource) ds).setPassword(PASSWORD);
                //获取连接
                connection = ds.getConnection();
                //打印连接，打印内容不为空，则连接正常；打印内容为空或报异常，则连接不正常
                System.out.println(connection);
                //执行SQL,获取到返回结果
                String sql = " select id,name,chinese,math,english from exam_result where id = ?";//?代表占位符
                //创建操作命令
                statement = connection.prepareStatement(sql);
                statement.setInt(1,3);
                resultSet = statement.executeQuery();
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

