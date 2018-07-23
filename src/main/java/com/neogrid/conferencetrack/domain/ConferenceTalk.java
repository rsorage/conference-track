package com.neogrid.conferencetrack.domain;

public class ConferenceTalk {

    private String title;
    private int duration; // in minutes

    public ConferenceTalk(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("ConferenceTalk [title='%s', duration=%d min]", title, duration);
    }

}
