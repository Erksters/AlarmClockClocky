package edu.ksu.erksters.soundthealarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import edu.ksu.erksters.soundthealarm.CalendarDayStuffGlobalization.CalendarDays;
import java.util.ArrayList;
import java.util.List;

public class CreateAlarmEvent extends AppCompatActivity implements AdapterView.OnItemSelectedListener , View.OnClickListener {

    ArrayList<AlarmEvent> newAlarms = new ArrayList<>();
    Spinner HourSpinner;
    Spinner MinuteSpinner;
    Spinner AMPMSpinner ;
    CheckBox Sunday ;
    CheckBox Monday ;
    CheckBox Tuesday;
    CheckBox Wednesday;
    CheckBox Thursday;
    CheckBox Friday ;
    CheckBox Saturday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alarm_event);

        newAlarms = new ArrayList<>();
        HourSpinner = (Spinner) findViewById(R.id.HourSpinner);
        MinuteSpinner = (Spinner) findViewById(R.id.MinuteSpinner);
        AMPMSpinner = (Spinner) findViewById(R.id.AMPMSpinner);
        Sunday = (CheckBox) findViewById(R.id.Sunday);
        Monday = (CheckBox) findViewById(R.id.Monday);
        Tuesday = (CheckBox) findViewById(R.id.Tuesday);
        Wednesday = (CheckBox) findViewById(R.id.Wednesday);
        Thursday = (CheckBox) findViewById(R.id.Thursday);
        Friday = (CheckBox) findViewById(R.id.Friday);
        Saturday = (CheckBox) findViewById(R.id.Saturday);

//
//        Submission.setOnClickListener(this);

        // Spinner Drop down elements
        List<String> HoursCategories = new ArrayList<String>();
        HoursCategories.add("1");
        HoursCategories.add("2");
        HoursCategories.add("3");
        HoursCategories.add("4");
        HoursCategories.add("5");
        HoursCategories.add("6");
        HoursCategories.add("7");
        HoursCategories.add("8");
        HoursCategories.add("9");
        HoursCategories.add("10");
        HoursCategories.add("11");
        HoursCategories.add("12");

        List<String> MinutesCategories = new ArrayList<String>();
        MinutesCategories.add("00");
        MinutesCategories.add("15");
        MinutesCategories.add("30");
        MinutesCategories.add("45");

        List<String> AMPMCategories = new ArrayList<String>();
        AMPMCategories.add("a.m.");
        AMPMCategories.add("p.m.");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, HoursCategories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        HourSpinner.setAdapter(dataAdapter);

        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, MinutesCategories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MinuteSpinner.setAdapter(dataAdapter);

        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, AMPMCategories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AMPMSpinner.setAdapter(dataAdapter);

        Button Submission = (Button) findViewById(R.id.SubmitButton);
        Submission.setOnClickListener(this);

    }

    public void onClick(View view){
            if (Sunday.isChecked()) {
                newAlarms.add(new AlarmEvent(CalendarDays.Sunday, Integer.parseInt(HourSpinner.getSelectedItem().toString()), Integer.parseInt(MinuteSpinner.getSelectedItem().toString())));
            }
            if (Monday.isChecked()) {
                newAlarms.add(new AlarmEvent(CalendarDays.Monday, Integer.parseInt(HourSpinner.getSelectedItem().toString()), Integer.parseInt(MinuteSpinner.getSelectedItem().toString())));
            }
            if (Tuesday.isChecked()) {
                newAlarms.add(new AlarmEvent(CalendarDays.Tuesday, Integer.parseInt(HourSpinner.getSelectedItem().toString()), Integer.parseInt(MinuteSpinner.getSelectedItem().toString())));
            }
            if (Wednesday.isChecked()) {
                newAlarms.add(new AlarmEvent(CalendarDays.Wednesday, Integer.parseInt(HourSpinner.getSelectedItem().toString()), Integer.parseInt(MinuteSpinner.getSelectedItem().toString())));
            }
            if (Thursday.isChecked()) {
                newAlarms.add(new AlarmEvent(CalendarDays.Thursday, Integer.parseInt(HourSpinner.getSelectedItem().toString()), Integer.parseInt(MinuteSpinner.getSelectedItem().toString())));
            }
            if (Friday.isChecked()) {
                newAlarms.add(new AlarmEvent(CalendarDays.Friday, Integer.parseInt(HourSpinner.getSelectedItem().toString()), Integer.parseInt(MinuteSpinner.getSelectedItem().toString())));
            }
            if (Saturday.isChecked()) {
                newAlarms.add(new AlarmEvent(CalendarDays.Saturday, Integer.parseInt(HourSpinner.getSelectedItem().toString()), Integer.parseInt(MinuteSpinner.getSelectedItem().toString())));
            }

            Intent intent = new Intent();
            intent.putExtra("data", newAlarms);
            setResult(2, intent);
            finish();//finishing activity
        }


        @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    

}

