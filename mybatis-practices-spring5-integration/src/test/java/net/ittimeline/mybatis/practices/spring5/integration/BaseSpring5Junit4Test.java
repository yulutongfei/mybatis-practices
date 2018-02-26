package net.ittimeline.mybatis.practices.spring5.integration;

import net.ittimeline.mybatis.practices.spring5.integration.service.ServiceFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import net.ittimeline.mybatis.practices.spring5.integration.configuration.ApplicationConfiguartion;

/**
 * Spring5集成Junit
 * @author tony ittimeline@163.com
 * @date 2018-02-24-下午2:59
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
//指定测试类的运行者
@RunWith(SpringJUnit4ClassRunner.class)
//指定spring配置类
@ContextConfiguration(classes = {ApplicationConfiguartion.class})
//事务配置
@Transactional
public abstract class BaseSpring5Junit4Test {


    @Autowired
    protected ServiceFactory serviceFactory;
}
