import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;

public class DButil3 {
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
                String sql = "insert into exam_result(id,name,chinese,math,english) values(?,?,?,?,?)";//?代表占位符
                //创建操作命令
                statement = connection.prepareStatement(sql);
                statement.setInt(1,11);//x是要插入的id号，不能和库里面已经有的重复，否则插不进去
                statement.setString(2,"AB");
                statement.setBigDecimal(3,new BigDecimal("86.3"));
                statement.setBigDecimal(4,new BigDecimal("96.7"));
                statement.setBigDecimal(5,new BigDecimal("86.5"));
                System.out.println(sql);
                int num = statement.executeUpdate();//更新操作
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                //释放资源，要倒序释放
                try {
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

