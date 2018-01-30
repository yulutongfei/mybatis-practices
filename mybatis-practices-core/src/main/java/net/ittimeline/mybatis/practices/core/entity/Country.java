package net.ittimeline.mybatis.practices.core.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 国家实体类
 * @author tony ittimeline@163.com
 * @date 2018-01-25-上午12:03
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public class Country {
    private Long countryId;

    private String countryName;

    private String countryCode;


    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("countryId", countryId)
                .append("countryName", countryName)
                .append("countryCode", countryCode)
                .toString();
    }
}
