package com.example.third_assignment.Adapter;

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

    public StudentAdapter(List<Student> students) {
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
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final Student student = students.get(position);
        holder.fullname.setText(student.getFullName());
        holder.age.setText(student.getAge());
        holder.gender.setText(student.getGender());
        holder.address.setText(student.getAddress());
        holder.studentImage.set
        holder.btnDelete.setOnClickListener(
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView studentImage;
        TextView fullname, age, address, gender;
        Button btnDelete;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            studentImage = itemView.findViewById(R.id.imageView);
            fullname = itemView.findViewById(R.id.tvName);
            age = itemView.findViewById(R.id.tvAge);
            address = itemView.findViewById(R.id.tvAddress);
            gender = itemView.findViewById(R.id.tvGender);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}


