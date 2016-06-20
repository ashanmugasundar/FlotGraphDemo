package com.learn.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.learn.domain.ApplicationOrder;
import com.learn.util.DaoMapper;

public class ApplicationDAOImpl implements ApplicationDAO {

    private JdbcTemplate jdbcTemplateObject;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplateObject = jdbcTemplate;
    }
    
    public List<ApplicationOrder> getOrderCountForLineChart(String sourceName, String date) {
        String query = "select o.source as \"Source\", o.order_count as \"Order Count\", o.last_updated as \"Timestamp\" from order_count_history o where o.last_updated like '%" + date + "%' and o.source = '" + sourceName + "' order by o.last_updated";
        return jdbcTemplateObject.query(query, new DaoMapper());
    }

}
