package org.frank.java.io;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class DirectoryTest {

    private static final Logger logger = LoggerFactory.getLogger(DirectoryTest.class);
    
    @Test
    public void testCreateDirectory(){
        String filePath = "d://io//demo";
        File file = new File(filePath);
        if(file.mkdir()){
            logger.info("目录创建成功");
        }else{
            logger.info("目录创建失败");
        }
    }

    /**
     * 删除目录是要确保这里面的文件全部删除, 如果还有文件，那不会删除成功
     * 
     * */
    @Test
    public void testDeleteDirectory(){
        String filePath = "d://io//demo";
        File file = new File(filePath);
        if(file.exists()){
            if(file.delete()){
                logger.info("目录删除成功");
            }else{
                logger.info("目录删除失败...");
            }
        }else{
            logger.info("目录不存在...");
        }
    }
}
