package com.bit.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBTest4 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
    public static void main(String[] args){
        Connection connection = null;
        PreparedStatement statement = null;
        //ResultSet resultSet = null;
        try {
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource) ds).setURL(URL);
            ((MysqlDataSource) ds).setUser(USERNAME);
            ((MysqlDataSource) ds).setPassword(PASSWORD);
            connection = ds.getConnection();
            System.out.println(connection);

            String sql = "delete from exam_result where id = 11";
            statement = connection.prepareStatement(sql);
            System.out.println(sql);

            int num = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
