package net.ittimeline.mybatis.practices.core.utils;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库工具类
 * 目前主要用于读取database.properties文件获取数据库连接
 * @author tony ittimeline@163.com
 * @date 2018-01-25-上午12:22
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public class DataBaseUtils {
    /**
     * 通过读取类路径下的database.properties文件获取数据库连接信息
     * @return
     */
    public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {


        Properties properties=new Properties();

        try(

                Reader reader= Resources.getResourceAsReader("database.properties");
        )
        {
            properties.load(reader);
        }


        String drivers=properties.getProperty("jdbc.driver");
        //加载驱动
        Class.forName(drivers);

        String url=properties.getProperty("jdbc.url");
        String username=properties.getProperty("jdbc.username");
        String password=properties.getProperty("jdbc.password");

        //建立连接
        return DriverManager.getConnection(url,username,password);

    }
}
