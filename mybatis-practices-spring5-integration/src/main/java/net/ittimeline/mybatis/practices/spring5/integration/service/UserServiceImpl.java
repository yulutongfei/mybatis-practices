package net.ittimeline.mybatis.practices.spring5.integration.service;

import cn.hutool.core.bean.BeanUtil;
import net.ittimeline.mybatis.practices.pojo.dto.UserDTO;
import net.ittimeline.mybatis.practices.pojo.persist.UserDO;
import net.ittimeline.mybatis.practices.spring5.integration.mapper.UserDOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tony ittimeline@163.com
 * @date 2018-02-24-下午1:51
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserDOMapper userDOMapper;


    @Override
    public UserDTO login(UserDTO userDTO) {
        UserDO condition =new UserDO();
        condition.setUserName(userDTO.getUserName());
        condition.setPassword(userDTO.getPassword());
        UserDO userDO= userDOMapper.find(condition);
        UserDTO result=new UserDTO();
        BeanUtils.copyProperties(userDO,result);
        return result;
    }

    @Override
    public boolean register(UserDTO userDTO) {
        boolean registerResultFlag =false;

        UserDO userDO=new UserDO();
        BeanUtils.copyProperties(userDTO,userDO);
        int count= userDOMapper.insert(userDO);

        if(count>0){
            registerResultFlag=true;
        }
        return registerResultFlag;
    }



    @Override
    public boolean updateUserInfo(UserDTO userDTO) {
        boolean updateMobileFlag=false;

        UserDO userDO=new UserDO();
        BeanUtil.copyProperties(userDTO,userDO);
        int count= userDOMapper.update(userDO);
        if(count>0){
            updateMobileFlag=true;
        }

        return updateMobileFlag;
    }

    @Override
    public boolean exists(UserDTO userDTO) {
        UserDO userDO=new UserDO(userDTO.getUserName());
        UserDO findResult =userDOMapper.find(userDO);
        if(findResult!=null){
            return true;
        }

        return false;
    }

    @Override
    public long countTotalUser() {
        return userDOMapper.countTotalUser();
    }
}
