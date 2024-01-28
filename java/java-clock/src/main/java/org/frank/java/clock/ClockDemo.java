package org.frank.java.clock;


import com.sun.istack.internal.NotNull;
import org.frank.java.clock.exceptions.TimeException;

public class ClockDemo {
    
    public String clocke(@NotNull String time) {
        if (time.length() != 4) {
            throw new TimeException("Wrong time format or value.");
        }
        String hourStr = time.substring(0, 2);
        String minuteStr = time.substring(2, 4);
        int hour;
        int minute;
        try {
            hour = Integer.parseInt(hourStr);
            minute = Integer.parseInt(minuteStr);
        } catch (NumberFormatException e) {
            throw new TimeException("Wrong time format or value.");
        }

        if (hour > 23 || hour < 0 || minute > 59 || minute < 0) {
            throw new TimeException("Wrong time format or value.");
        }

        double hourAngle = hour % 12 * 30 + minute * 0.5;
        double minuteAngle = minute * 6;
        
        double angleDiff = minuteAngle - hourAngle;
        
        if(angleDiff < 0){
            angleDiff = 360 + angleDiff;
        }
        
        if(angleDiff % 1 == 0){
            return Integer.toString((int) angleDiff);
        } else {
            return Double.toString(angleDiff);
        }
    }
}
