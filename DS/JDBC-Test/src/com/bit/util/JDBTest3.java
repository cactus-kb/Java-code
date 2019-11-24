package com.bit.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;

public class JDBTest3 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
    public static void main(String[] args){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource) ds).setURL(URL);
            ((MysqlDataSource) ds).setUser(USERNAME);
            ((MysqlDataSource) ds).setPassword(PASSWORD);
            connection = ds.getConnection();
            System.out.println(connection);

            String sql = "select id,name,chinese,math,english from exam_result where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,3);
            System.out.println(sql);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                BigDecimal chinese = resultSet.getBigDecimal("chinese");
                BigDecimal math = resultSet.getBigDecimal("math");
                BigDecimal english = resultSet.getBigDecimal("english");
                System.out.printf("id is: %s, name = %s, chinese = %s, math = %s, english = %s",id, name, chinese, math, english);
                System.out.println();
            }
        }
        //catch (ClassNotFoundException e) {
        //    e.printStackTrace();
        //}
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
