package com.example.CareFoMe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleListViewHolder> {

    Context context;
    List<Schedule> scheduleList = new ArrayList<>();



    public ScheduleAdapter(Context context, List<Schedule> scheduleList) {
        this.context = context;
        this.scheduleList = scheduleList;


    }

    @NonNull
    @Override
    public ScheduleListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_layout_schedule,parent,false);
        return new ScheduleListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ScheduleListViewHolder holder, final int position) {

        final Schedule schedule = scheduleList.get(position);


        holder.tv_name.setText(schedule.fullName);
        holder.tv_doc_name.setText(schedule.docName);
        holder.tv_email.setText(schedule.email);
        holder.tv_date.setText(schedule.date);
        holder.tv_time.setText(schedule.time);
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper sqlHelper = new DBHelper(context);
                sqlHelper.deleteSchedule(schedule.id);
                scheduleList.remove(scheduleList.get(holder.getAdapterPosition()));
                notifyDataSetChanged();
                Toast.makeText(context, "delete success ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    class ScheduleListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_doc_name;
        TextView tv_email;
        TextView tv_date;
        TextView tv_time;
        Button btnRemove;


        public ScheduleListViewHolder(View itemView) {
            super(itemView);
            tv_name =  itemView.findViewById(R.id.textViewScheduleName);
            tv_doc_name = itemView.findViewById(R.id.textViewScheduleDoctorName);
            tv_email = itemView.findViewById(R.id.textViewScheduleEmail);
            tv_date = itemView.findViewById(R.id.textViewScheduleDate);
            tv_time = itemView.findViewById(R.id.textViewScheduleTime);
            btnRemove=  itemView.findViewById(R.id.btRemove);

        }
    }
}
