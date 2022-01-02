package org.zhouhy.java;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhouhy.java.domain.Insurance;

import java.util.Optional;

public class OptionalTest1 {

    private static final Logger logger = LoggerFactory.getLogger(OptionalTest1.class);
    
    @Test
    public void optionCreationTest(){
        Optional<Insurance> optionalInsurance = Optional.empty();        
    }
}
