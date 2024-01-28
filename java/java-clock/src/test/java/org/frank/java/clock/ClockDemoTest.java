package org.frank.java.clock;

import org.frank.java.clock.exceptions.TimeException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClockDemoTest {
    
    @Test
    public void testClockeWhenInputCorrectValue_thenReturnExpectedValue(){
        ClockDemo clockDemo = new ClockDemo();
        String angleDiff = clockDemo.clocke("1230");
        assertEquals("165",angleDiff);

        angleDiff = clockDemo.clocke("0245");
        assertEquals("187.5",angleDiff);

        angleDiff = clockDemo.clocke("1445");
        assertEquals("187.5",angleDiff);

        angleDiff = clockDemo.clocke("1754");
        assertEquals("147",angleDiff);

        angleDiff = clockDemo.clocke("1710");
        assertEquals("265",angleDiff);

        angleDiff = clockDemo.clocke("1200");
        assertEquals("0",angleDiff);
    }


    @Test(expected = TimeException.class)
    public void testClockeWhenInputInCorrectValue_thenThorwTimeException(){
        ClockDemo clockDemo = new ClockDemo();
        clockDemo.clocke("123044");
        clockDemo.clocke("123a");
        clockDemo.clocke("1360");
    }
}
