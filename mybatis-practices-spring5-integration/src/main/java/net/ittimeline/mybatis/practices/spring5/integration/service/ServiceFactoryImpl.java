package net.ittimeline.mybatis.practices.spring5.integration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tony ittimeline@163.com
 * @date 2018-02-26-下午5:37
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
@Service
public class ServiceFactoryImpl implements ServiceFactory {


    @Autowired
    private UserService userService;

    @Override
    public UserService getUserService() {
        return userService;
    }
}
