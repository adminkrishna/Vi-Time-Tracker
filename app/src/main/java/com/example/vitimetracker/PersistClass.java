package com.example.vitimetracker;


import com.google.firebase.database.FirebaseDatabase;

public class PersistClass extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
