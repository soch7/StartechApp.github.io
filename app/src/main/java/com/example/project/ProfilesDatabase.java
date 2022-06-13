package com.example.project;

import android.database.sqlite.SQLiteDatabase;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class ProfilesDatabase {

    String name,email,phone,occupation,qualification,category;
    SQLiteDatabase Project;

    ProfilesDatabase(String name, String email, String phone, String occupation,
                     String qualification, String category){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.occupation=occupation;
        this.qualification=qualification;
        this.category=category;

        Project = SQLiteDatabase.openOrCreateDatabase("ProjectApp",null);

        Project.execSQL("CREATE TABLE IF NOT EXISTS profiles(name VARCHAR,email VARCHAR,phone VARCHAR," +
                "occupation VARCHAR,qualification VARCHAR,category VARCHAR)");

    }



    void Insert(){

        Project.execSQL("INSERT INTO profiles VALUES ("+name+","+email+","+phone+","+occupation+","+qualification+","+category+")");
    }

}
