package com.neogrid.conferencetrack.domain;

import com.neogrid.conferencetrack.util.Time;

public class TalkSession {

    private ConferenceTalk talk;
    private Time startTime;
    private Time endTime;

    public TalkSession(ConferenceTalk talk, Time startTime, Time endTime) {
        this.talk = talk;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TalkSession(ConferenceTalk talk, Time startTime, int duration) {
        this.talk = talk;
        this.startTime = startTime;
        this.endTime = startTime.plusMinutes(duration);
    }

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
        return String.format("%s %s", startTime, talk);
    }
}
