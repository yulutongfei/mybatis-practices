package net.ittimeline.mybatis.practices.core.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;

import java.io.IOException;
import java.io.Reader;

/**
 * @author tony ittimeline@163.com
 * @date 2018-01-25-上午12:35
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public abstract class BaseMappperTest {
    private static final Logger logger = LogManager.getLogger();


    /**
     * SqlSessionFactory一旦创建就应该在运行期间一直存在，没有任何理由对它进行清除或者重建，使用SqlSessionFactory的最佳实践
     * 是在运行期间不要重复创建多次。
     */
    private static SqlSessionFactory sqlSessionFactory;

    /**
     *
     */
    @BeforeClass
    public static void init(){

        try(
                //读取mybatis配置文件
                Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
        ) {

            sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();

            logger.error("读取mybatis配置文件错误",e);
        }

    }

    /**
     * 获取SqlSession
     * SqlSession的实例不是线程安全的，因此不能线程共享，它的最佳作用于是请求或者是方法方法作用域
     * 决不能将SqlSession实例的引用放在一个类的静态域,甚至一个类的实例变量也不行
     * @return
     */
    public SqlSession getSqlSession(){

        return sqlSessionFactory.openSession();
    }
}
