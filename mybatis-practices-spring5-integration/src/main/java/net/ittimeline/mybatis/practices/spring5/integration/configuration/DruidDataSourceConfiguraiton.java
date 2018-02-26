package net.ittimeline.mybatis.practices.spring5.integration.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 阿里巴巴数据库连接池Druid配置
 * @author tony ittimeline@163.com
 * @date 2018-02-26-上午11:30
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
@Configuration
@PropertySource("classpath:database.properties")
public class DruidDataSourceConfiguraiton {

    private static final Logger LOGGER= LogManager.getLogger();


    /**********************读取位于ClassPath路径下的database.properties属性配置文件，然后将属性值设置到对应的成员变量中********************/
    @Value("${datasource.druid.driverClassName}")
    private String driverClassName;

    @Value("${datasource.druid.url}")
    private String url;

    @Value("${datasource.druid.username}")
    private String userName;

    @Value("${datasource.druid.password}")
    private String password;

    @Value("${datasource.druid.initialSize}")
    private int initialSize;

    @Value("${datasource.druid.minIdle}")
    private int minIdle;


    @Value("${datasource.druid.maxActive}")
    private int maxActive;


    @Value("${datasource.druid.maxWait}")
    private long maxWait;

    @Value("${datasource.druid.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;


    @Value("${datasource.druid.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;

    @Value("${datasource.druid.validationQuery}")
    private String validationQuery;

    @Value("${datasource.druid.testWhileIdle}")
    private boolean testWhileIdle;


    @Value("${datasource.druid.testOnBorrow}")
    private boolean testOnBorrow;


    @Value("${datasource.druid.testOnReturn}")
    private boolean testOnReturn;



    @Value("${datasource.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;


    @Value("${datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;


    @Value("${datasource.druid.filters}")
    private String filters;


    /**
     * 基于阿里巴巴的Druid数据库连接池实现
     * @return
     */
    @Bean
    public DataSource dataSource(){


        DruidDataSource dataSource =new DruidDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);


        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();

            LOGGER.error("build datasource fail "+e.getMessage());
        }
        return dataSource;
    }

}
