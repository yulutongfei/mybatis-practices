package net.ittimeline.mybatis.practices.spring5.integration.mapper;

import net.ittimeline.mybatis.practices.pojo.persist.UserDO;

/**
 * @author tony ittimeline@163.com
 * @date 2018-02-24-下午1:12
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */

public interface UserDOMapper {

    /**
     * 新增用户
     * @param user
     * @return
     */
    public int insert(UserDO user);

    /**
     * 修改用户信息
     * @param userDO
     * @return
     */
    public int update(UserDO userDO);



    /**
     * 根据用户信息(例如id,用户名和密码)获取单个用户
     * @param userDO
     * @return
     */
    public UserDO find(UserDO userDO);

    /**
     * 统计注册用户数量
     * @return
     */
    public Long countTotalUser();


}
