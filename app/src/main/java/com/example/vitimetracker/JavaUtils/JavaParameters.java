package com.example.vitimetracker.JavaUtils;

import android.net.Uri;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class JavaParameters {

    public static FirebaseUser currentUser;
    public static GoogleSignInAccount mAccount;
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference myRef = database.getReference();
    public static DatabaseReference employee_details = myRef.child("employee_details");
    public static DatabaseReference users_uid_map = myRef.child("users_uid_map");

    public static Map<String, Object> usersMap;
    public static String userName;
    public static String userMailId;
    public static String userUid;
    public static String useremplId;
    public static Uri getUserImageId;
    public static boolean empMapped;

}
