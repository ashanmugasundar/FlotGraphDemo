package com.learn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.dao.ApplicationDAO;
import com.learn.domain.ApplicationOrder;

/**
 * Interface of Application related Services to fetch/update or delete any application related activities
 * @author sundar.arumugam
 * 
 */
@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationDAO applicationDao;

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ApplicationServiceImpl.class.getName());

    public List<ApplicationOrder> getOrderCountForLineChart(String sourceName,
            String date) {
        LOGGER.info("Start getOrderCountForLineChart : Requests received - sourceName - {} & Date - {}",sourceName, date);
        List<ApplicationOrder> orderList = applicationDao.getOrderCountForLineChart(sourceName, date);
        if (orderList != null)
            LOGGER.info("End getOrderCountForLineChart : Sending response - {}",orderList.size());
        return orderList;
    }

}
