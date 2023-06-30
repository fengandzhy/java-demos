package org.frank.java.io;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IOTest {

    private static final Logger logger = LoggerFactory.getLogger(IOTest.class);

    @Test
    public void getClassPathTest(){
        logger.info(this.getClass().getResource("").getFile());
        logger.info(this.getClass().getResource("").getPath());
        logger.info(ClassLoader.getSystemResource("").getPath() );
        logger.info(FileOutPut.class.getResource("").getPath());
    }
    
    
}
