package net.ittimeline.mybatis.practices.core.mapper;

import net.ittimeline.mybatis.practices.core.entity.Country;

import java.util.List;

/**
 * @author tony ittimeline@163.com
 * @date 2018-01-25-上午12:05
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public interface CountryMapper {


    /**
     * 根据ID获取国家信息
     * @param countryId
     * @return
     */
    Country selectById(Long countryId);


    /**
     * 获取所有的国家集合
     * @return
     */
    List<Country> selectAll();
}
