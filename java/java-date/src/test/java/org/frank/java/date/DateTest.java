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

public class DateTest {

    private static final Logger logger = LoggerFactory.getLogger(DateTest.class);
    
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
}
