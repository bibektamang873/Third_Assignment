package com.example.third_assignment.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.third_assignment.Model.Student;
import com.example.third_assignment.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyHolder> {

    List<Student> students;
    Context context;

    public StudentAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_design,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        final Student student = students.get(position);
        holder.fullName.setText(student.getFullName());
        holder.age.setText(Integer.toString(student.getAge()));
        holder.gender.setText(student.getGender());
        holder.address.setText(student.getAddress()) ;

        String gen = student.getGender();
        if(gen.equals("Male")){
            holder.studentImage.setImageResource(R.drawable.icon_male);
        }else if(gen.equals("Female")){
            holder.studentImage.setImageResource(R.drawable.icon_female);
        }else{
            holder.studentImage.setImageResource(R.drawable.icon_others);
        }

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btnDelete){
                    students.remove(student);
                    notifyItemRemoved(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView studentImage;
        TextView fullName, age, address, gender;
        Button btnDelete;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            studentImage = itemView.findViewById(R.id.imageView);
            fullName = itemView.findViewById(R.id.tvName);
            age = itemView.findViewById(R.id.tvAge);
            address = itemView.findViewById(R.id.tvAddress);
            gender = itemView.findViewById(R.id.tvGender);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}


