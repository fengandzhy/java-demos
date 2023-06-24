package org.frank.java.jackson.util;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JSONUtil {
    private static final Logger logger = LoggerFactory.getLogger(JSONUtil.class);
    
    public JSONUtil(){}
    
    public static String toJsonString(Object data){
        if (ObjectUtils.isEmpty(data)){
            return "";
        }
        return "";
    }
}
