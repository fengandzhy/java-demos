package org.zhouhy.java.object;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    
    @Test
    public void compareTwoDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String x1 = "2018-06-05 10:02";
        String x2 = "2018-06-05 10:08";

        Date date1 = sdf.parse(x1);
        Date date2 = sdf.parse(x2);

        System.out.println(date1.getTime() > date2.getTime());

        System.out.println(date1.before(date2));

        System.out.println(date1.after(date2));
        
        Double.toString(3.22);

        System.out.println(date1.compareTo(date2));

        System.out.println(Double.toString(3.22));
    }
}
