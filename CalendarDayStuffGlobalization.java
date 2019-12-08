package edu.ksu.erksters.soundthealarm;

public class CalendarDayStuffGlobalization {
    public enum CalendarDays {
        Sunday(0), Monday(1), Tuesday(1), Wednesday(4), Thursday(5), Friday(6), Saturday(7);

        private final int value;
        private CalendarDays (int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }}


}
