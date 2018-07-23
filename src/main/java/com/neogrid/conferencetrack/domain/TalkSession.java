package com.neogrid.conferencetrack.domain;

import com.neogrid.conferencetrack.util.Time;

public class TalkSession {

    private ConferenceTalk talk;
    private Time startTime;
    private Time endTime;

    public ConferenceTalk getTalk() {
        return talk;
    }

    public void setTalk(ConferenceTalk talk) {
        this.talk = talk;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.format("TalkSession [talk='%s', startTime=%s, endTime='%s']", talk, startTime, endTime);
    }
}
