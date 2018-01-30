package net.ittimeline.mybatis.practices.core.mybatis;

import net.ittimeline.mybatis.practices.core.entity.Country;
import net.ittimeline.mybatis.practices.core.mapper.CountryMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * @author tony ittimeline@163.com
 * @date 2018-01-25-上午12:37
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public class CountryMapperTest extends  BaseMappperTest {
    private static final Logger logger = LogManager.getLogger();


    /**
     * 获取所有的国家列表
     */
    @Test
    public  void testSelectAll(){

        try(SqlSession sqlSession=getSqlSession();

        ){
            CountryMapper countryMapper=sqlSession.getMapper(CountryMapper.class);

            List<Country> countryList=countryMapper.selectAll();

            if(CollectionUtils.isNotEmpty(countryList)){
                logger.info("从数据库中获取国家列表"+countryList);

            }

        }


    }


    /**
     * 根据ID获取国家信息
     */
    @Test
    public void testSelectGetById(){
        try(SqlSession sqlSession=getSqlSession()){
            CountryMapper countryMapper=sqlSession.getMapper(CountryMapper.class);

            Country country=countryMapper.selectById(1L);

            if(null!=country){
                logger.info("根据指定的ID获取国家信息"+country);

            }

        }
    }

}
