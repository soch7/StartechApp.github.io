package com.example.project;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class StartupDatabase {

    String email,startupIdea,shortDesc,location;
    String name,phone,qualification;
    SQLiteDatabase Project;
    Context context;
    ContentValues initialValues;

    StartupDatabase(SQLiteDatabase project,String name,String shortDesc,String startupIdea,String qualification,String location,String email,String phone){

        this.name=name;
        this.email=email;
        this.startupIdea=startupIdea;
        this.location=location;
        this.phone=phone;
        this.shortDesc=shortDesc;
        this.qualification=qualification;


        Project=project;
        Project.execSQL("CREATE TABLE IF NOT EXISTS startups(name VARCHAR,shortDesc VARCHAR,startupIdea VARCHAR,qualification VARCHAR,location VARCHAR,email VARCHAR,phone VARCHAR)");

    }
    StartupDatabase(SQLiteDatabase project)
    {
        this.Project=project;
        Project.execSQL("CREATE TABLE IF NOT EXISTS startups(name VARCHAR,shortDesc VARCHAR,startupIdea VARCHAR,qualification VARCHAR,location VARCHAR,email VARCHAR,phone VARCHAR)");
    }


    void Insert(){

        initialValues = new ContentValues();

        initialValues.put("name",name);
        initialValues.put("shortDesc",shortDesc);
        initialValues.put("startupIdea",startupIdea);
        initialValues.put("qualification",qualification);
        initialValues.put("location",location);
        initialValues.put("email",email);
        initialValues.put("phone",phone);

        Project.insert("startups",null,initialValues);    }
}
