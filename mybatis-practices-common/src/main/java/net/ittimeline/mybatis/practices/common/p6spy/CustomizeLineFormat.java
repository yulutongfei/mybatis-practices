package net.ittimeline.mybatis.practices.common.p6spy;

import com.alibaba.druid.sql.SQLUtils;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * 自定义SQL格式
 * @author tony ittimeline@163.com
 * @date 2018-01-30-下午10:45
 * @website wwww.ittimeline.net
 * @see
 * @since JDK8u162
 */
public class CustomizeLineFormat implements MessageFormattingStrategy {

    public String buildMessage(String now, long elapsed, String sql) {
        StringBuffer content = new StringBuffer();
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(now) && org.apache.commons.lang3.StringUtils.isNotEmpty(Long.valueOf(elapsed).toString())
                && org.apache.commons.lang3.StringUtils.isNotEmpty(sql)) {
            content.append("当前时间:" + now);
            content.append(" SQL执行耗时(毫秒)为" + elapsed);
            content.append(" SQL执行的语句是\n" + SQLUtils.formatMySql(sql)+"\n\n");
        }
        return content.toString();
    }

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql) {
        return buildMessage(now, elapsed, sql);
    }

}
