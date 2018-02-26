package net.ittimeline.mybatis.practices.pojo.dto;

import net.ittimeline.mybatis.practices.pojo.User;

/**封装User业务数据
 * @author tony ittimeline@163.com
 * @date 2018-02-24-下午1:22
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public class UserDTO extends User {


    public UserDTO(){}

    public UserDTO(String userName,String password){
        super(userName,password);
    }

}
