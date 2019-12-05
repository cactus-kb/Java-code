import com.mysql.jdbc.Connection;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DButil {

    private static DataSource DATA_SOURSE;
    private static final String URL = "jdbc:mysql://localhost:3306/libery";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";

    private DButil() {

    }

    public static DataSource getDataSourse() {
        if (DATA_SOURSE == null) {
            DATA_SOURSE = new MysqlDataSource();
            ((MysqlDataSource) DATA_SOURSE).setURL(URL);
            ((MysqlDataSource) DATA_SOURSE).setUser(USER);
            ((MysqlDataSource) DATA_SOURSE).setPassword(PASSWORD);
        }
        return DATA_SOURSE;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = (Connection) getDataSourse().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}

