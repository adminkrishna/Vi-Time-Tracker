package com.example.vitimetracker.ui.home;

import static com.example.vitimetracker.JavaUtils.CalendarUtils.daysInMonthArray;
import static com.example.vitimetracker.JavaUtils.CalendarUtils.daysInWeekArray;
import static com.example.vitimetracker.JavaUtils.CalendarUtils.monthYearFromDate;
import static com.example.vitimetracker.JavaUtils.CalendarUtils.dayFromDate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vitimetracker.Adapter.CalendarAdapter;
import com.example.vitimetracker.Adapter.EventAdapter;
import com.example.vitimetracker.Event;
import com.example.vitimetracker.JavaUtils.CalendarUtils;
import com.example.vitimetracker.R;
import com.example.vitimetracker.databinding.FragmentHomeBinding;


import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class HomeFragment extends Fragment implements CalendarAdapter.OnItemListener{

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private View root;

    private TextView miniDate, miniMonthYear, miniDay;
    private ImageButton left, right;
    private TextView edit;

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));

        CalendarUtils.selectedDate = LocalDate.now();

        initWidgets();
        setWeekView();
        setMiniView();

        left.setOnClickListener(v -> previousWeekAction(v));
        right.setOnClickListener(v -> nextWeekAction(v));

        return root;
    }

    private void initWidgets()
    {
        calendarRecyclerView = root.findViewById(R.id.calendarRecyclerView);
        monthYearText = root.findViewById(R.id.monthYearTV);
        eventListView = root.findViewById(R.id.eventListView);

        miniDate = root.findViewById(R.id.Fragment01MiniDate);
        miniMonthYear = root.findViewById(R.id.Fragment01MiniMonthYear);
        miniDay = root.findViewById(R.id.Fragment01MiniDay);

        left = root.findViewById(R.id.Fragment01PreviousWeek);
        right = root.findViewById(R.id.Fragment01NextWeek);
        edit = root.findViewById(R.id.Fragment01Edit);
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 7);
        layoutManager.requestLayout();
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    @Override
    public void onItemClick(int position, LocalDate date) {
        CalendarUtils.selectedDate = date;
        setWeekView();
        setMiniView();
    }

    private void setMiniView() {
        miniDate.setText(String.format("%02d", CalendarUtils.selectedDate.getDayOfMonth()));
        miniMonthYear.setText(monthYearFromDate(CalendarUtils.selectedDate).replace(" ",", "));
        miniDay.setText(String.valueOf(dayFromDate(CalendarUtils.selectedDate)));

        if(ChronoUnit.DAYS.between(CalendarUtils.selectedDate,LocalDate.now()) < 2){
            edit.setVisibility(View.VISIBLE);
        } else {
            edit.setVisibility(View.INVISIBLE);
        }
    }

    public void previousWeekAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void nextWeekAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusWeeks(1);
        setWeekView();
    }
}