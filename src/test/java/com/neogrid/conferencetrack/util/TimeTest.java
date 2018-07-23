package com.neogrid.conferencetrack.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TimeTest {

    @Test(expected = IllegalArgumentException.class)
    public void invalidNegativeHour() {
        new Time(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidPositiveHour() {
        new Time(24);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidNegativeMinute() {
        new Time(0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidPositiveMinute() {
        new Time(0, 60);
    }

    @Test
    public void minTime() {
        Time time = new Time(0,0);

        String timeStr = time.toString();
        assert timeStr.equals("12:00AM");
    }

    @Test
    public void maxTime() {
        Time time = new Time(23,59);

        String timeStr = time.toString();
        assert timeStr.equals("11:59PM");
    }

    @Test
    public void cloneTime() {
        Time t1 = Time.now();
        Time t2 = new Time(t1);

        assert t1 != t2;
    }

    @Test
    public void timeIsBeforeAnother() {
        Time t1 = new Time(3,3);
        Time t2 = new Time(3,4);

        assert t1.before(t2);
    }

    @Test
    public void plusMinutes() {
        Time time = new Time(8, 50);
        time.addMinutes(10);

        assert time.getHour() == 9;
        assert time.getMinute() == 0;
    }

}
