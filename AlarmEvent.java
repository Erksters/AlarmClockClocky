package edu.ksu.erksters.soundthealarm;

import android.text.format.Time;
import java.util.Calendar;
import edu.ksu.erksters.soundthealarm.CalendarDayStuffGlobalization.CalendarDays;


public class AlarmEvent implements Comparable<AlarmEvent>{
    /**
     * Fields
     */
    private String _Description;
    public CalendarDays weekday;
    public int Hours;
    public int minutes;
    public Boolean Active;


    /**
     * public Constructor for an AlarmEvent.
     * @param Day Day of Week taken as an int
     * @param Hour  int
     * @param minutes   int
     */
    public AlarmEvent( CalendarDays Day, int Hour, int minutes ){
        weekday = Day;
        Hours = Hour;
        this. minutes = minutes;
        Active = true;

        //_Description can be hour:Minute WeekDay
        _Description = Integer.toString(Hour) + ":" + Integer.toString(minutes) + " on " + weekday.name();

    }

    /**
     * Method to disactivate the Alarm
     */
    public void AlarmOff() {
        Active = false;
    }

    /**
     * Method to activate the Alarm
     */
    public void AlarmOn() {
        Active = true;
    }

    /**
     * Method to return the Description
     * @return
     */
    @Override
    public String toString(){
        return _Description ;
    }

    @Override
    public int compareTo(AlarmEvent Alarm) {
        return (this.weekday.getValue() < Alarm.weekday.getValue() ? -1 :
                (this.weekday.getValue() == Alarm.weekday.getValue() ? 0 : 1));
    }
}
