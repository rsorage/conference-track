package com.neogrid.conferencetrack.util;

import com.neogrid.conferencetrack.domain.ConferenceTalk;

import java.util.Comparator;

public class TalkDurationComparator implements Comparator<ConferenceTalk> {

    @Override
    public int compare(ConferenceTalk t1, ConferenceTalk t2) {
        if(t1.getDuration() > t2.getDuration())
            return 1;

        if(t1.getDuration() < t2.getDuration())
            return -1;

        return 0;
    }

}
