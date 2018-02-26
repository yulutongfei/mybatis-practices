package net.ittimeline.mybatis.practices.pojo;

/**
 * 网站注册来源枚举
 * @author tony ittimeline@163.com
 * @date 2018-02-24-下午5:14
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public enum RegisterResourceEnum {
    ANDROID("Android客户端"),
    IOS("IOS客户端"),
    H5("H5端"),
    PC("PC端"),
    OPENAPI("开放接口注册");

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;


    RegisterResourceEnum(String text){
        this.text=text;
    }
}
