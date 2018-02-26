package net.ittimeline.mybatis.practices.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tony ittimeline@163.com
 * @date 2018-02-24-下午2:09
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public class User  implements Serializable{

    /**
     * 用户编号
     */
    private Long userId;

    /**用户登录:支持用户名/手机号/邮箱登录*/

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;


    /**
     * 密码
     */
    private String password;

    /**
     * 身份证照
     */
    private String cardNumber;


    /*****************注册信息************/

    /**
     * 注册IP
     */
    private String registerIp;


    /**
     * 注册来源 PC/H5/Android/IOS
     */
    private String registerResource;

    /**
     * 注册日期
     */
    private Date registerDate;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getRegisterResource() {
        return registerResource;
    }

    public void setRegisterResource(String registerResource) {
        this.registerResource = registerResource;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }


    public User(){}

    public User(String userName){
        this.userName=userName;
    }

    public User(String userName,String password){
        this(userName);
        this.password=password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("userName", userName)
                .append("mobile", mobile)
                .append("email", email)
                .append("password", password)
                .append("cardNumber", cardNumber)
                .append("registerIp", registerIp)
                .append("registerResource", registerResource)
                .append("registerDate", registerDate)
                .toString();
    }
}
