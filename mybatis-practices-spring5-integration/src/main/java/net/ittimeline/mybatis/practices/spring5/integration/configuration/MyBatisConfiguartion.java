package net.ittimeline.mybatis.practices.spring5.integration.configuration;

import net.ittimeline.mybatis.practices.spring5.integration.constants.SystemConstants;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author tony ittimeline@163.com
 * @date 2018-02-24-上午11:13
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
@Configuration
@Import(DruidDataSourceConfiguraiton.class)
@MapperScan(basePackages = SystemConstants.MAPPER_BASE_PACKAGE)
public class MyBatisConfiguartion {



    private static final Logger LOGGER= LogManager.getLogger();


    private static final String TYPE_ALIASES_PACKAGE= "net.ittimeline.mybatis.practices.pojo.persist";




    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource){

        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);


        //TODO 添加分页插件

        //添加mapper的XML目录
        ResourcePatternResolver resourcePatternResolver=new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath:mappers/*.xml"));

            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("build sqlSessionFactory fail "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }




}
