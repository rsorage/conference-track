package com.neogrid.conferencetrack.util;

import java.time.LocalDateTime;

public class Time {

    private int hour;
    private int minute;

    public Time(int hour) {
        this(hour, 0);
    }

    public Time(int hour, int minute) {
        if(hour < 0 || hour > 23)
            throw new IllegalArgumentException(String.format("Invalid hour: %d", hour));
        if(minute > 59)
            throw new IllegalArgumentException(String.format("Invalid minute: %d", minute));

        this.hour = hour;
        this.minute = minute;
    }

    // Copy constructor
    public Time(Time another) {
        this.hour = another.hour;
        this.minute = another.minute;
    }

    public static Time now() {
        LocalDateTime now = LocalDateTime.now();
        return new Time(now.getHour(), now.getMinute());
    }

    public boolean before(Time another) {
        if(this.hour < another.hour)
            return true;

        else if(this.hour == another.hour && this.minute < another.minute)
            return true;

        return false;
    }

    @Override
    public String toString() {
        String ampm = this.hour < 12 ? "AM" : "PM";
        int hour = (this.hour % 12);
        hour = hour == 0 ? 12 : hour;

        return String.format("%02d:%02d%s", hour, this.minute, ampm);
    }

}
