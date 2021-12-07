package com.example.fitworkout.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitworkout.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sun.bob.mcalendarview.MCalendarView;
import sun.bob.mcalendarview.MarkStyle;
import sun.bob.mcalendarview.vo.DateData;

public class FragmentCalendar extends Fragment {

    MCalendarView calendarView;
    TextView tvDate;
    Calendar curDate;


    public FragmentCalendar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        calendarView = view.findViewById(R.id.calendarView);
        tvDate = view.findViewById(R.id.tvDate);

        //region CALENDAR TEST

        // Instanciar 'Calendar' com a data
        curDate = Calendar.getInstance();

        // Criar um conjunto de DateData
        DateData dateData1 = new DateData(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH) + 1, 1);
        DateData dateData2 = new DateData(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH) + 1, 2);
        DateData dateData3 = new DateData(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH) + 1, 3);
        DateData dateData4 = new DateData(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH) + 1, 4);

        // Marcar as datas com alguns exemplos de tipos de marcacao
        calendarView.markDate(dateData1.setMarkStyle(MarkStyle.DOT, MarkStyle.defaultColor));
        calendarView.markDate(dateData2.setMarkStyle(MarkStyle.BACKGROUND, MarkStyle.defaultColor));
        calendarView.markDate(dateData3.setMarkStyle(MarkStyle.LEFTSIDEBAR, MarkStyle.defaultColor));
        calendarView.markDate(dateData4.setMarkStyle(MarkStyle.RIGHTSIDEBAR, MarkStyle.defaultColor));

        //endregion

        return view;
    }
}