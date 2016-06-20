package com.learn.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.learn.domain.ApplicationOrder;

public interface ApplicationDAO {
    /**
     * This is the method to be used to initialize database resources ie.
     * connection.
     */
    public void setJdbcTemplate(JdbcTemplate ds);

    public List<ApplicationOrder> getOrderCountForLineChart(String sourceName,String date);

}
