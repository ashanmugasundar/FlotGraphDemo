package com.learn.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.learn.domain.ApplicationConstant;
import com.learn.domain.ApplicationOrder;
import com.mysql.jdbc.ResultSetMetaData;

public class DaoMapper implements RowMapper<ApplicationOrder> {
    public ApplicationOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        ApplicationOrder applicationOrder = new ApplicationOrder();
        applicationOrder.setSource("N/A");
        applicationOrder.setOrderCount(new Integer(0));
        applicationOrder.setTimestamp(null);
        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        int columns = rsmd.getColumnCount();
        for (int i = 1; i <= columns; i++) {
            if ("Source".equals(rsmd.getColumnLabel(i)))
                applicationOrder.setSource(rs.getString("Source"));
           else if (ApplicationConstant.ORDER_COUNT.getValue().equals(rsmd
                    .getColumnLabel(i)) && rs.getObject(ApplicationConstant.ORDER_COUNT.getValue()) != null)
                applicationOrder.setOrderCount(new Integer(rs.getObject(ApplicationConstant.ORDER_COUNT.getValue())
                        .toString()));
            else if (ApplicationConstant.TIMESTAMP.getValue().equals(rsmd
                    .getColumnLabel(i)))
                applicationOrder.setTimestamp(rs.getTimestamp(ApplicationConstant.TIMESTAMP.getValue()));
        }
        return applicationOrder;
    }
}
