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
        if(minute < 0 || minute > 59)
            throw new IllegalArgumentException(String.format("Invalid minute: %d", minute));

        this.hour = hour;
        this.minute = minute;
    }

    // Copy constructor
    public Time(Time another) {
        this.hour = another.hour;
        this.minute = another.minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
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

    /**
     * Add given minutes to current time object.
     *
     * @param minutes Minutes to be added to current time object.
     */
    public void addMinutes(int minutes) {
        int totalMinutes = this.getMinute() + minutes;

        int newHour = this.hour + (totalMinutes / 60);
        int newMinute = totalMinutes % 60;

        setHour(newHour);
        setMinute(newMinute);
    }

    /**
     * Creates a new time object with added minutes.
     *
     * @param minutes Minutes to be added.
     * @return New time object.
     */
    public Time plusMinutes(int minutes) {
        int totalMinutes = this.getMinute() + minutes;

        int newHour = this.hour + (totalMinutes / 60);
        int newMinute = totalMinutes % 60;

        return new Time(newHour, newMinute);
    }

    @Override
    public String toString() {
        String ampm = this.hour < 12 ? "AM" : "PM";
        int hour = (this.hour % 12);
        hour = hour == 0 ? 12 : hour;

        return String.format("%02d:%02d%s", hour, this.minute, ampm);
    }

}
