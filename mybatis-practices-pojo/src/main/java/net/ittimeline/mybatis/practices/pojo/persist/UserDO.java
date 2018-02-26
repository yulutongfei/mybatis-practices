package net.ittimeline.mybatis.practices.pojo.persist;

import net.ittimeline.mybatis.practices.pojo.User;

/**
 * User Data Object 对应数据库表 t_user
 * @author tony ittimeline@163.com
 * @date 2018-01-30-下午11:37
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public class UserDO extends User {


    public UserDO(){}

    public UserDO(String userName){
        super(userName);
    }


}
