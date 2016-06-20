package com.learn.domain;

import java.text.SimpleDateFormat;

/**
 * Enum class to declare all the DateFormat related constants which will be used in server side.
 * @author sundar.arumugam
 * 
 */
public enum ApplicationDateFormat {

    DATETIME_FORMAT("dd-MM-yyyy HH:mm:ss"),
    DATE_FORMAT("dd-MM-yyyy"),
    DB_DATE_FORMAT("yyyy-MM-dd");

    private final SimpleDateFormat value;
   
    /**
     * Constructor class
     * @param value
     */
    ApplicationDateFormat(String value) {
        this.value = new SimpleDateFormat(value);
    }
    
    /**
     * Utility method to assign the DateFormat constant value
     * @return
     */
    public SimpleDateFormat getValue() {
        return this.value;
    }
}