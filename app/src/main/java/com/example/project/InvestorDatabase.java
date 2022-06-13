package com.example.project;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class InvestorDatabase {


    String name,investment,ideaPreferences,qualification,email,phone;
    SQLiteDatabase Project;
    ContentValues initialValues;

    InvestorDatabase(SQLiteDatabase project,String name,String investment, String ideaPreferences,String qualification,String email,String phone){

        this.name=name;
        this.investment=investment;
        this.ideaPreferences=ideaPreferences;
        this.qualification=qualification;
        this.email=email;
        this.phone=phone;

        Project = project;

        Project.execSQL("CREATE TABLE IF NOT EXISTS investors(name VARCHAR,investment VARCHAR,ideaPreferences VARCHAR,qualification VARCHAR,email VARCHAR,phone VARCHAR)");

    }

    InvestorDatabase(SQLiteDatabase Project1)
    {
        Project =Project1;

        Project.execSQL("CREATE TABLE IF NOT EXISTS investors(name VARCHAR,investment VARCHAR,ideaPreferences VARCHAR,qualification VARCHAR,email VARCHAR,phone VARCHAR)");


    }

    void Insert(){

        initialValues = new ContentValues();

        initialValues.put("name",name);
        initialValues.put("investment",investment);
        initialValues.put("ideaPreferences",ideaPreferences);
        initialValues.put("qualification",qualification);
        initialValues.put("email",email);
        initialValues.put("phone",phone);

        Project.insert("investors",null,initialValues);
    }
}
