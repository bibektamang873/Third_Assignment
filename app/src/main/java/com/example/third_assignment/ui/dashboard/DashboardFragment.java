package com.example.third_assignment.ui.dashboard;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.third_assignment.Model.Student;
import com.example.third_assignment.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    private DashboardViewModel dashboardViewModel;

    EditText etFullname, etAge, etAddress;
    RadioGroup rgGender;
    Button btnSave;

    public static List<Student> students =new ArrayList<>();
    String fullname, age, gender, address;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        etFullname = root.findViewById(R.id.etFullName);
        etAge = root.findViewById(R.id.etAge);
        etAddress = root.findViewById(R.id.etAddress);
        rgGender = root.findViewById(R.id.rgGender);
        btnSave = root.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);




        /*
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
         */
        return root;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnSave){
            fullname = etFullname.getText().toString();
            age = etAge.getText().toString();
            address = etAddress.getText().toString();

          if (validate()){
            students.add(new Student(fullname, gender, address, Integer.parseInt(age)));
              Toast.makeText(getContext(), "Student Added Successfully", Toast.LENGTH_SHORT).show();
          }
        }

    }

    private boolean validate() {
        if (TextUtils.isEmpty(fullname)){
            etFullname.setError("Enter Full Name");
            return false;
        }
        if (TextUtils.isEmpty(age)) {
            etAge.setError("Enter Age");
            return false;
        }
        if(!TextUtils.isDigitsOnly(age)){
            etAge.setError("Invalid Age");
            return false;
        }
        if (TextUtils.isEmpty(address)) {
            etAge.setError("Enter Address");
            return false;
        }
        if(TextUtils.isEmpty(gender)){
            Toast.makeText(getContext(), "Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        if (i == R.id.rbMale) {
            gender = "Male";
            Toast.makeText(getContext(), "Male", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.rbFemale) {
            gender = "Female";
            Toast.makeText(getContext(), "Female", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.rbOthers) {
            gender = "Others";
            Toast.makeText(getContext(), "Others", Toast.LENGTH_SHORT).show();
        }
    }
}