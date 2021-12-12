package com.example.vitimetracker;


import com.google.firebase.database.FirebaseDatabase;

public class Persist extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
