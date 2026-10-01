package com.jdbc.myjdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    // 前置工作：mysql jar 包放在 libs 下
    public static void main(String[] args) throws SQLException {
        // 注册驱动
        Driver driver = new com.mysql.jdbc.Driver();

        // 得到连接
        String url = "jdbc:mysql://localhost:3306/test"; // url 代表连接到哪个数据库去
        Properties properties = new Properties();
        properties.setProperty("user", "root"); // 用户
        properties.setProperty("password", "123456"); // 密码
        Connection connection = driver.connect(url, properties);

        // 执行 MySQL
        String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '110')";
        Statement statement = connection.createStatement(); // 执行sql语句并返回
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");

        // 退出
        statement.close();
        connection.close();

    }
}