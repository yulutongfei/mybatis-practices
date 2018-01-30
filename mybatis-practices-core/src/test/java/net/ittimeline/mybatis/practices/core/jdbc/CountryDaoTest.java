package net.ittimeline.mybatis.practices.core.jdbc;

import net.ittimeline.mybatis.practices.core.entity.Country;
import net.ittimeline.mybatis.practices.core.utils.DataBaseUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tony ittimeline@163.com
 * @date 2018-01-25-上午12:24
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public class CountryDaoTest {

    private static final Logger LOGGER = LogManager.getLogger();


    /**
     * 定义SQL语句,?表示占位符
     */
    private static final String sql ="select country_id,country_name,country_code from t_country where country_id = ?";


    /**
     * 根据ID获取国家信息
     */
    @Test
    public void testGetCountryById() {

        //使用JDK7的新特性 自动关闭资源的try语句
        try (
                //获取数据库连接
                Connection connection = DataBaseUtils.getConnection();

                //创建PreparedStatement对象 预编译SQL 提高执行效率
                /*
                 * 相比Statement接口而言
                 * 创建PreparedStatement对象时SQL语句可以使用占位符，当SQL语句需要使用参数时，无需要拼接SQL字符串
                 * 而且PreparedStatement可以防止SQL注入，
                 * PreparedStatement预编译SQL语句，性能比Statement更好
                 *
                 **/
                PreparedStatement preparedStatement = connection.prepareStatement(sql)

        ) {

            preparedStatement.setLong(1,1L);


            try (

                    //执行查询的SQL语句并获取结果集
                    ResultSet resultSet = preparedStatement.executeQuery()

            ) {
                List<Country> countryList = new ArrayList<>();

                //遍历结果集，将查询到的数据封装到countryList对象中
                while (resultSet.next()) {

                    Country country = new Country();
                    country.setCountryId(resultSet.getLong("country_id"));
                    country.setCountryName(resultSet.getString("country_name"));
                    country.setCountryCode(resultSet.getString("country_code"));

                    countryList.add(country);
                }

                LOGGER.info("通过JDBC获取国家信息列表的结果是" + countryList);

            }


        } catch (IOException | ClassNotFoundException | SQLException exception) {

            exception.printStackTrace();

            LOGGER.error("使用JDBC访问MySQL数据库操作失败" + exception);
        }


    }

}
