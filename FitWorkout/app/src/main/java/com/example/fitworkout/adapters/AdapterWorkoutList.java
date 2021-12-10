package com.example.fitworkout.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fitworkout.R;
import com.example.fitworkout.models.Workout;

import java.util.ArrayList;

public class AdapterWorkoutList extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Workout> workoutArrayList;

    public AdapterWorkoutList(Context context, ArrayList<Workout> workoutArrayList) {
        this.context = context;
        this.workoutArrayList = workoutArrayList;
    }

    @Override
    public int getCount() {
        return workoutArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return workoutArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return workoutArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = inflater.inflate(R.layout.item_list_workout, null);

        /* Optimização */
        ViewHolderList viewHolder = (ViewHolderList) view.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolderList(view);
            view.setTag(viewHolder);
        }

        viewHolder.update(workoutArrayList.get(position));

        return view;
    }

    private static class ViewHolderList {
        private final TextView tvName;
        private final TextView tvCaloriesBurned;

        public ViewHolderList(View view) {
            this.tvName = view.findViewById(R.id.tvWorkoutName);
            this.tvCaloriesBurned = view.findViewById(R.id.tvWorkoutCalories);
        }

        public void update(Workout workout) {
            tvName.setText(workout.getName());
            tvCaloriesBurned.setText(workout.getCaloriesBurned());
        }
    }
}
