package com.example.vitimetracker;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;

import com.example.vitimetracker.JavaUtils.JavaParameters;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.vitimetracker.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Home extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FirebaseAuth mAuth;
    private AlertDialog dialog;
    public JavaParameters parameters = new JavaParameters();

    @Override
    protected void onStart() {
        super.onStart();
//        if(FirebaseAuth.getInstance().getCurrentUser() == null)
//            startActivity(new Intent(getApplicationContext(), Login.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);

//        AlertDialog.Builder customBuild = new AlertDialog.Builder(Home.this);
//        LayoutInflater inflater = getLayoutInflater();
//        customBuild.setView(inflater.inflate(R.layout.custom_loading, null));
//        customBuild.setCancelable(false);
//
//        dialog = customBuild.create();
//        dialog.show();
//
//        readData(parameters.employee_details, new OnGetDataListener() {
//            @Override
//            public void onSuccess(DataSnapshot dataSnapshot) {
//                parameters.usersMap = (Map<String, Object>) dataSnapshot.getValue();
//                dialog.dismiss();
//            }
//            @Override
//            public void onStart() {}
//
//
//        });

    }

//    public interface OnGetDataListener {
//        void onSuccess(DataSnapshot dataSnapshot);
//        void onStart();
//    }
//
//    public void readData(DatabaseReference ref, final OnGetDataListener listener) {
//        listener.onStart();
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                listener.onSuccess(dataSnapshot);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//    }

}