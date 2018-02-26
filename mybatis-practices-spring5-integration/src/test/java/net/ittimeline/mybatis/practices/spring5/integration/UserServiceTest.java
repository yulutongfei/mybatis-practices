package net.ittimeline.mybatis.practices.spring5.integration;

import net.ittimeline.mybatis.practices.pojo.dto.UserDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Date;

/**
 * @author tony ittimeline@163.com
 * @date 2018-02-24-下午3:24
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public class UserServiceTest extends BaseSpring5Junit4Test {


    private static final Logger LOGGER= LogManager.getLogger();

    @Test
    public void testRegister(){

        UserDTO userDTO=new UserDTO();
        userDTO.setUserName("tony");
        userDTO.setPassword("666666");
        userDTO.setMobile("186xxxxxxxx");
        userDTO.setCardNumber("42102319xxxxxxxxxx");
        userDTO.setEmail("18601767221@163.com");
        userDTO.setRegisterDate(new Date());
        userDTO.setRegisterIp("127.0.0.1");
        userDTO.setRegisterResource("Android客户端");
        boolean registerResult=serviceFactory.getUserService().register(userDTO);
        if(registerResult){
            LOGGER.info("注册成功，注册的来源是"+userDTO.getRegisterResource());
        }
        else{
            LOGGER.error("注册失败");
        }

    }

    @Test
    public void testUpdatePassword(){

        UserDTO userDTO=new UserDTO();
        userDTO.setUserName("tony");
        userDTO.setPassword("88888888");
        userDTO.setMobile("188********");


        boolean existsFlag =serviceFactory.getUserService().exists(userDTO);

        if(existsFlag){
            boolean updateResult =serviceFactory.getUserService().updateUserInfo(userDTO);

            if(updateResult){
                LOGGER.info("修改密码成功,新密码是"+userDTO.getPassword()+"新手机号是"+userDTO.getMobile());

            }

            else{
                LOGGER.error("修改密码失败");
            }
        }


    }


    @Test
    public void testLogin(){


        UserDTO userDTO=new UserDTO("tony","88888888");

        UserDTO loginResult =serviceFactory.getUserService().login(userDTO);

        LOGGER.info(loginResult);
    }


    @Test
    public void testCountTotalUser(){
        Long totalUser=serviceFactory.getUserService().countTotalUser();
        LOGGER.info("当前网站注册的人数是"+totalUser);
    }
}
