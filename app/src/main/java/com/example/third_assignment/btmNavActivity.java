package com.example.third_assignment;

import android.os.Bundle;

import com.example.third_assignment.Model.Student;
import com.example.third_assignment.ui.addStudent.AddStudentFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class btmNavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btm_nav);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        AddStudentFragment.students.add(new Student("Bibek Tamang", "Male", "Baneshwor", 22));
        AddStudentFragment.students.add(new Student("Sita Rai", "Female", "Butwal", 20));
        AddStudentFragment.students.add(new Student("Soniya Shrestha", "Others", "Bhaktapur", 21));

    }


}
