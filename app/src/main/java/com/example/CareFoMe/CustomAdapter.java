package com.example.CareFoMe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ListViewHolder> {


    Bundle bundle;
    Context context;
    List<UserData> dataList = new ArrayList<>();
    LayoutInflater inflater;
    Intent apt;
    String username,email;



    public CustomAdapter(Context context, List dataList1,String u,String e) {

        this.context = context;
        this.dataList = dataList1;
        inflater = LayoutInflater.from(context);
        username=u;
        email=e;




    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View convertView = inflater.inflate(R.layout.linear_layout, parent, false);
        ListViewHolder viewHolder = new ListViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {


        final String doc_name = dataList.get(position).name;
        holder.iv_book.setTag(position);
        holder.tv_name.setText(doc_name);
        holder.tv_spec.setText(dataList.get(position).speciality);
       //bundle.putString("Name",dataList.get(position).name);

        holder.iv_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                apt = new Intent(context,Appointment.class);
                apt.putExtra("username",username);
                apt.putExtra("Email",email);
                apt.putExtra("Doc Name",doc_name);



                context.startActivity(apt);

            }
        });







    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_spec;
        Button iv_book;


        public ListViewHolder(View itemView) {
            super(itemView);

            context =  itemView.getContext();
            tv_name =  itemView.findViewById(R.id.textViewTV);
            tv_spec =  itemView.findViewById(R.id.textViewSpec);
            iv_book=  itemView.findViewById(R.id.imageViewbook);

        }
    }


}
