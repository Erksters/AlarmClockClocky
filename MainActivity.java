package edu.ksu.erksters.soundthealarm;

import android.content.Intent;
import android.os.Parcelable;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import edu.ksu.erksters.soundthealarm.CalendarDayStuffGlobalization.CalendarDays;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    private Calendar calendar;
//    public TextView Textstuff;
    public AlarmClock alarmClock;
    public Button CreateNewAlarm;
    ListView simpleList;
    ArrayList<AlarmEvent> Alarms;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Alarms = new ArrayList<AlarmEvent>();

        AlarmEventSorter sorter = new AlarmEventSorter(Alarms);
        ArrayList newAlarms = sorter.getSorted();
        newAlarms = sorter.getHourAndMinutesSort(newAlarms);


        CreateNewAlarm = findViewById(R.id.CreateAlarmButton);
        CreateNewAlarm.setOnClickListener(this);

        simpleList = (ListView)findViewById(R.id.ListOfAlarms);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, GetDescriptions(newAlarms));

        simpleList.setAdapter(adapter);

    }

    @Override
    public void onClick(View view){
        ArrayList<AlarmEvent> object = new ArrayList<AlarmEvent>();
        Intent go = new Intent (this, CreateAlarmEvent.class);

        go.putExtra("data", object);
        startActivityForResult(go, 2);
    }

    // Call Back method  to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 ) {
//            try {
                ArrayList<AlarmEvent> stuffretrieved = (ArrayList<AlarmEvent>) data.getSerializableExtra("data");
                for (int x = 0; x < stuffretrieved.size(); x++) {
                    AddAlarm(stuffretrieved.get(x));
                }
                adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, GetDescriptions(Alarms));

            simpleList.setAdapter(adapter);
//            }
//            catch (Exception e){
//                String message = "Error Retrieving info from intent";
//                CreateNewAlarm.setText(message);
        }
    }



    /**
     * Method to retrieve a list of Descriptions of all set alarms.
     * Will be used in the adapter for the Spinner "simpleList"
     * @param Alarms
     * @return
     */
    public String[] GetDescriptions(ArrayList<AlarmEvent> Alarms){
        String [] results = new String[Alarms.size()];
        for(int i = 0; i< results.length; i++){
            results[i] = Alarms.get(i).toString();
        }
        return results;
    }

    public void AddAlarm(AlarmEvent alarm){
        Alarms.add(alarm);
    }

    public void LookforRepetitionInAlarmList(){

    }

    /**
     * Handles the user changing pages to add an AlarmEvent
     */
    public void GoCreateAnAlarmEvent() {
        Intent Go = new Intent(this, CreateAlarmEvent.class);
        startActivityForResult(Go, 2);

//        startActivity(Go);
    }

}




//        Textstuff = findViewById(R.id.Text1);
//        String result = GetTodaysDay() +"\n"+ GetTheHour() + "\n" + GetTheMinute();
//        Textstuff.setText(result);


//    public int GetTodaysDay(){
//        calendar = Calendar.getInstance();
//        return calendar.get(Calendar.DAY_OF_WEEK);
//    }
//
//    public int GetTheHour(){
//        calendar = Calendar.getInstance();
//        return calendar.get(Calendar.HOUR_OF_DAY);
//    }
//
//    public int GetTheMinute(){
//        calendar = Calendar.getInstance();
//        return calendar.get(Calendar.MINUTE);
//    }