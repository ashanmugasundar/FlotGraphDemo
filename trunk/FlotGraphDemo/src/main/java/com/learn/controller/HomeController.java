package com.learn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.domain.ApplicationOrder;
import com.learn.service.ApplicationService;


@Controller
public class HomeController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
        
    @Autowired
    private ApplicationService applicationService;
    
    /**
     * default route to Home screen
     * 
     * @return
     */
    @RequestMapping(value = "/")
    public String getHomePage() {
        LOGGER.info("Entered getHomePage() method");
        return "index";
    }

    @RequestMapping(value = "/getOrderCountForLineChart", produces = "application/json")
    @ResponseBody 
    public List<ApplicationOrder> getOrderCountForLineChart(
            @RequestParam("source") String sourceName,
            @RequestParam("date") String date) {
        LOGGER.info("Start getOrderCountForLineChart : Requests received - sourceName - {} & Date - {}",sourceName, date);
        List<ApplicationOrder> orderList = applicationService.getOrderCountForLineChart(sourceName,date);
        if (orderList != null)
            LOGGER.info("End getOrderCountForLineChart : Sending response - {}",orderList.size());
        return orderList;
    }
  
    
   
}
