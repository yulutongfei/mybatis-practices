package net.ittimeline.mybatis.practices.spring5.integration.handler;

import net.ittimeline.mybatis.practices.pojo.RegisterResourceEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tony ittimeline@163.com
 * @date 2018-02-24-下午5:07
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public class CustomEnumTypeHandler extends BaseTypeHandler<RegisterResourceEnum> {






    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, RegisterResourceEnum parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public RegisterResourceEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public RegisterResourceEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public RegisterResourceEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
