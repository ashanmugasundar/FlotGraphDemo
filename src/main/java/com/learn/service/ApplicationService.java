package com.learn.service;

import java.util.List;

import com.learn.domain.ApplicationOrder;

/**
 * Interface of Application related Services to fetch/update or delete any application related activities
 * 
 * @author sundar.arumugam
 * 
 */
public interface ApplicationService {

    /**
     * Service Method for retrieving ordercount according to dates and given source name
     * 
     * @return List<ApplicationOrder>
     */
    public List<ApplicationOrder> getOrderCountForLineChart(String sourceName, String date);
}
