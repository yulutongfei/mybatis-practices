package net.ittimeline.mybatis.practices.spring5.integration.configuration;

import net.ittimeline.mybatis.practices.spring5.integration.constants.SystemConstants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 系统全局配置类
 * @author tony ittimeline@163.com
 * @date 2018-02-24-上午11:03
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
@Configuration
@ComponentScan(basePackages = {SystemConstants.COMPONENT_SCAN_PACKAGE_NAME})
public class ApplicationConfiguartion {



}
