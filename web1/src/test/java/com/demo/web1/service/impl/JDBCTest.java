package com.demo.web1.service.impl;

import java.sql.*;

public class JDBCTest {
    // TODO 测试preparedstatement

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");       //加载驱动
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "123456");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers where first_name = ?");
        statement.setString(1, "david' or '1=1");
        System.out.println(statement);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }
        connection.close();
    }
}
