package com.example.third_assignment.ui.studentList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.third_assignment.Adapter.StudentAdapter;
import com.example.third_assignment.R;
import com.example.third_assignment.ui.addStudent.AddStudentFragment;

public class StudentListFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView rvStudents;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_student_list, container, false);

        rvStudents = root.findViewById(R.id.rvStudents);

        StudentAdapter adapter = new StudentAdapter(getActivity(), AddStudentFragment.students);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvStudents.setLayoutManager(layoutManager);
        rvStudents.setAdapter(adapter);

        return root;
    }
}