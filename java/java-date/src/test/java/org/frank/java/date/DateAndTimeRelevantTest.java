package org.frank.java.date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateAndTimeRelevantTest {

    private static final Logger logger = LoggerFactory.getLogger(DateAndTimeRelevantTest.class);

    @Test
    public void fromDateToLocalDateTest(){
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        logger.info("Date = " + date);
        logger.info("LocalDate = " + localDate);
    }

    @Test
    public void fromLocalDateToDateTest(){
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());
        logger.info("LocalDate = " + localDate);
        logger.info("Date = " + date);
    }

    @Test
    public void fromCalendarToDateTest(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,2000);
        cal.set(Calendar.MONTH,12);
        cal.set(Calendar.DATE,23);
        Date date = cal.getTime();
        logger.info("Date = " + date);
    }
    @Test
    public void DateTest(){
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("时间戳="+currentTimeMillis);
        
        Date date = new Date();
        System.out.println("当前时间="+date);
        System.out.println("当前时间="+date.toString());

        //转换为本地时区：2023年2月11日 下午12:04:03
        System.out.println("当前时间，Locale="+date.toLocaleString());
        //转换为GMT时区：11 Feb 2023 04:04:03 GMT
        System.out.println("当前时间，GMT="+date.toGMTString());

        System.out.println("年="+(date.getYear() + 1900)); // 必须加上1900

        System.out.println("月="+(date.getMonth() + 1)); // 0~11，必须加上1
        System.out.println("日="+date.getDate()); // 1~31，不能加1
        System.out.println("时="+date.getHours()); // 0~23
        System.out.println("分="+date.getMinutes()); // 0~59，不能加1
        System.out.println("秒="+date.getSeconds()); // 0~59，不能加1
        System.out.println("时间戳="+date.getTime()); // 时间戳，毫秒值

        //构造对象的另一个方法，已过时。year:要减去1900，月份从0开始，0-11；日期是1-31
        Date d1 =  new Date(1982-1900, 5-1, 1);
        System.out.println("出生日期="+d1);
        Date d2 = new Date();
        System.out.println("出生日期="+d2);
        long time = d2.getTime() - d1.getTime();
        System.out.println("已活天数="+time/1000/60/60/24);       
    }
}
