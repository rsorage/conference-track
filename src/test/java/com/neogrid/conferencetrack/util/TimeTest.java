package com.neogrid.conferencetrack.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TimeTest {

    @Test
    public void timeIsBeforeAnother() {
        Time t1 = new Time(3,4);
        Time t2 = new Time(3,4);

        assert(t1.before(t2));
    }

}
