package com.learn.domain;

/**
 * Enum class to declare all the constants which will be used in server side.
 * @author sundar.arumugam
 */
public enum ApplicationConstant {

    ORDER_COUNT("Order Count"),
    REGION("Region"),
    TIMESTAMP("Timestamp");

    private final String value;
    
    /**
     * Constructor class for declaring constants with its value
     * @param value
     */
    ApplicationConstant(String value) {
        this.value = value;
    }
    
    /**
     * Utility method to assign the constant value
     * @return
     */
    public String getValue() {
        return this.value;
    }
}