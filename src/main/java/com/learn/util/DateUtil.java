package com.learn.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date util to convert string object from String to Date for persisting in
 * table.
 * 
 * @author sundar.arumugam
 */
public class DateUtil {

    private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class
            .getName());

    /**
     * Private constructor to make sure that no one creating instance
     */
    private DateUtil() {

    }

    /**
     * Method to convert string object from String to Date for persisting in
     * table
     * 
     * @param dateString
     * @param DateFormat
     * @return Date
     */
    public static Date convertStringtoDate(String dateString, DateFormat format) {
        LOG.debug("Entered - convertStringtoDate - Parameter : {}",dateString);
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            LOG.error("Error while parsing the date : method convertStringtoDate",e);
        }
        LOG.debug("Exit - convertStringtoDate- Returning null ");
        return null;
    }

    /**
     * Method to convert Date object to String for showing in GUI screen
     * 
     * @param date
     * @param DateFormat
     * @return String
     */
    public static String convertDatetoString(Date date, DateFormat format) {
        LOG.debug("Entered - convertDatetoString - Parameter : {}",date);
        return format.format(date);
    }
}
