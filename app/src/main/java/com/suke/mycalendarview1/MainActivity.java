package com.suke.mycalendarview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.suke.calendarview.DatePickerController;
import com.suke.calendarview.DayPickerView;
import com.suke.calendarview.SimpleMonthAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DayPickerView dayPickerView = findViewById(R.id.calendar);
        DayPickerView.DataModel dataModel = new DayPickerView.DataModel();
        dataModel.yearStart = 0;
        dataModel.monthStart = 0;
        dataModel.monthCount = 2;
        dataModel.leastDaysNum = 2;
        dataModel.mostDaysNum = 100;

        //设置满房日期
        List<SimpleMonthAdapter.CalendarDay> busyDays = new ArrayList<>();
        SimpleMonthAdapter.CalendarDay busyDay1 = new SimpleMonthAdapter.CalendarDay(2018, 9, 3);
        SimpleMonthAdapter.CalendarDay busyDay2 = new SimpleMonthAdapter.CalendarDay(2018, 9, 4);
        SimpleMonthAdapter.CalendarDay busyDay3 = new SimpleMonthAdapter.CalendarDay(2018, 9, 5);
        busyDays.add(busyDay1);
        busyDays.add(busyDay2);
        busyDays.add(busyDay3);
        dataModel.busyDays = busyDays;

        //设置禁用日期
        List<SimpleMonthAdapter.CalendarDay> invalidDays = new ArrayList<>();
        SimpleMonthAdapter.CalendarDay invalidDay1 = new SimpleMonthAdapter.CalendarDay(2018, 9, 10);
        SimpleMonthAdapter.CalendarDay invalidDay2 = new SimpleMonthAdapter.CalendarDay(2018, 9, 11);
        SimpleMonthAdapter.CalendarDay invalidDay3 = new SimpleMonthAdapter.CalendarDay(2018, 9, 12);
        invalidDays.add(invalidDay1);
        invalidDays.add(invalidDay2);
        invalidDays.add(invalidDay3);
        dataModel.invalidDays = invalidDays;

        dayPickerView.setParameter(dataModel, new DatePickerController() {
            @Override
            public void onDayOfMonthSelected(SimpleMonthAdapter.CalendarDay calendarDay) {
                Log.d("Tag","onDayOfMonthSelected==============单天选择");
            }

            @Override
            public void onDateRangeSelected(List<SimpleMonthAdapter.CalendarDay> list) {
                Log.d("Tag","onDateRangeSelected==============范围选择");
            }

            @Override
            public void alertSelectedFail(FailEven failEven) {
                Log.d("Tag","alertSelectedFail==============选择日期时出现错误");
            }
        });
    }
}
