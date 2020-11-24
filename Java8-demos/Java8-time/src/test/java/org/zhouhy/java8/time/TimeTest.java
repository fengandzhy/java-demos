package org.zhouhy.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.YEARS;

public class TimeTest {
    
    @Test
    public void test1(){
        LocalDate today = LocalDate.now();
        System.out.println("Today is "+today);
        
    }

    @Test
    public void test2(){
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year: %d Month: %d day: %d \t %n",year,month,day);
    }

    /**
     * 示例3 在Java 8中如何获取某个特定的日期
     * */
    @Test
    public void test3(){
        LocalDate birthday = LocalDate.of(2015,12,4);
        System.out.println("Birthday is "+birthday);
    }

    /**
     * 示例4 在Java 8中如何检查两个日期是否相等
     * */
    @Test
    public void test4(){
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2015,12,4);
        if(birthday.equals(today)){
            System.out.println("Same day ");                    
        }else{
            System.out.println("Not the same day ");
        }
    }


    /**
     * 示例5 在Java 8中如何检查重复事件，比如说生日
     * */
    @Test
    public void test5(){
        LocalDate now = LocalDate.now();
        LocalDate birthdate = LocalDate.of(2015,11,25);
        MonthDay today = MonthDay.from(now);
        MonthDay birthday = MonthDay.of(birthdate.getMonthValue(),birthdate.getDayOfMonth());        
        if(today.equals(birthday)){
            System.out.println("Happy birthday!");
        }
    }

    /**
     * 示例6 如何在Java 8中获取当前时间
     * */
    @Test
    public void test6(){
        LocalTime now = LocalTime.now();
        System.out.println("Now is "+now);
    }

    /**
     * 示例7 如何增加时间里面的小时数
     * */
    @Test
    public void test7(){
        LocalTime now = LocalTime.now();
        LocalTime newTime = now.plusHours(2);
        System.out.println("After 2 hours is "+newTime);
    }

    /**
     * 示例8 如何获取1周后的日期
     * */
    @Test
    public void test8(){
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1,ChronoUnit.WEEKS);
        System.out.println("After 1 week is "+nextWeek);
    }

    /**
     * 示例9 一年前后的日期
     * */
    @Test
    public void test9(){
        LocalDate today = LocalDate.now();
        LocalDate lastYear = today.minus(1,YEARS);
        LocalDate nextYear = today.plus(1,YEARS);
        System.out.println("One year ago "+lastYear);
        System.out.println("One year after "+nextYear);
    }

    /**
     * 示例10 在Java 8中使用时钟
     * */
    @Test
    public void test10(){
        Clock clock = Clock.systemUTC();
        System.out.println("Clock:"+clock);
        Clock.systemDefaultZone();
        System.out.println("Clock:"+clock);
    }

    /**
     * 示例11 在Java中如何判断某个日期是在另一个日期的前面还是后面
     * */
    @Test
    public void test11(){
        LocalDate today = LocalDate.now();
        LocalDate certainDay = LocalDate.of(2020,11,25);
        if(today.isBefore(certainDay)){
            System.out.println("today is before the " +certainDay);
        }
        
        if(today.isAfter(certainDay)){
            System.out.println("today is after the " +certainDay);
        }

        if(today.isEqual(certainDay)){
            System.out.println("today is equal the " +certainDay);
        }       
    }

    /**
     * 示例12 在Java 8中处理不同的时区
     * 对应时区的那个文本可别弄错了，否则你会碰到这么一个异常：
     * */
    @Test
    public void test12(){
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,america);
        System.out.println(zonedDateTime);
    }

    /**
     * 示例13 如何表示固定的日期，比如信用卡过期时间
     * */
    @Test
    public void test13(){
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpire = YearMonth.of(2021,Month.JULY);
        System.out.printf("Days in month year %s %n", creditCardExpire);
    }

    /**
     * 示例14 如何在Java 8中检查闰年
     * */
    @Test
    public void test14(){
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
            System.out.println(today.getYear()+" is Leap year");
        }else {
            System.out.println( today.getYear()+" is not a Leap year");
        }
    }

    /**
     * 示例15 两个日期之间包含多少天，多少个月
     * */
    @Test
    public void test15(){
        LocalDate today = LocalDate.now();
        LocalDate nextRelease = LocalDate.of(2020,Month.DECEMBER,18);
        Period toNextRelease = Period.between(today,nextRelease);
        System.out.println( " to next release "+toNextRelease.getDays());
    }
}
