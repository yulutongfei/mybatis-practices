package net.ittimeline.mybatis.practices.spring5.integration.service;

import net.ittimeline.mybatis.practices.pojo.dto.UserDTO;

/**
 * 用户模块业务逻辑
 * 目前只包括登录、注册和修改密码，统计用户数量四个常用的功能
 * @author tony ittimeline@163.com
 * @date 2018-02-24-下午1:21
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
 public interface UserService {


    /**
     * 用户登录
     * @param userDTO
     * @return
     */
     UserDTO login(UserDTO userDTO);

    /**
     * 用户注册
     * @param userDTO
     * @return
     */
     boolean register(UserDTO userDTO);


    /**
     * 用户修改信息 例如密码手机号 用户名等等
     * @param userDTO
     * @return
     */
     boolean updateUserInfo(UserDTO userDTO);


    /**
     * 检查用户是否存在 作为修改用户信息的依据
     * @param userDTO
     * @return
     */
    boolean exists(UserDTO userDTO);



    /**
     * 统计注册用户的数量
     * @return
     */
     long countTotalUser();




}
