package com.test.flavors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView TextViewBuildURL;

    WeekView weekView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextViewBuildURL = (TextView) findViewById(R.id.TextViewBuildURL);
        TextViewBuildURL.setText(BuildConfig.SERVER_URL);

        weekView = (WeekView) findViewById(R.id.weekView);
        weekView.setNumberOfVisibleDays(4);

        weekView.setMonthChangeListener(new MonthLoader.MonthChangeListener() {
            @Override
            public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                List<WeekViewEvent> events = new ArrayList<>();
                WeekViewEvent EventsToLoad = new WeekViewEvent(1, "Raj" + "\n\n" + "Android", Calendar.getInstance(), Calendar.getInstance());
                events.add(EventsToLoad);
                return events;
            }
        });
    }
}
