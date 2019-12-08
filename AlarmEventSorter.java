package edu.ksu.erksters.soundthealarm;

import java.util.ArrayList;
import java.util.Collections;
import edu.ksu.erksters.soundthealarm.AlarmEvent;

public class AlarmEventSorter {
    ArrayList<AlarmEvent> AlarmEvent = new ArrayList<>();

    public AlarmEventSorter(ArrayList<AlarmEvent> Alarms) {
        this.AlarmEvent = Alarms;
    }

    public ArrayList<AlarmEvent> getSorted() {
        Collections.sort(AlarmEvent);
        return AlarmEvent;
    }

    public ArrayList<AlarmEvent> getHourAndMinutesSort(ArrayList<AlarmEvent> AlarmEvent) {
        for (int j = 0; j < AlarmEvent.size() - 1; j++){ //Go through every element except the last one
            if (AlarmEvent.get(j).weekday == AlarmEvent.get(j + 1).weekday) { //if the left and the right are on the same weekday
                if (AlarmEvent.get(j).Hours > AlarmEvent.get(j + 1).Hours) { //if the left has a greater Hour than the one on the right
                    AlarmEvent temp = AlarmEvent.get(j);
                    AlarmEvent.set(j, AlarmEvent.get(j + 1));
                    AlarmEvent.set(j + 1, temp);
                    j = 0;

                } else if (AlarmEvent.get(j).Hours == AlarmEvent.get(j + 1).Hours) {
                    if (AlarmEvent.get(j).minutes > AlarmEvent.get(j + 1).minutes) {
                        AlarmEvent temp = AlarmEvent.get(j);
                        AlarmEvent.set(j, AlarmEvent.get(j + 1));
                        AlarmEvent.set(j + 1, temp);
                        j = 0;
                    }
                }
            }
        }
        return AlarmEvent;
    }
}
