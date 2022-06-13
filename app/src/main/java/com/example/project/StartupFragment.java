package com.example.project;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StartupFragment extends Fragment {

    RecyclerView recyclerView;
    //StartupAdapter startupAdapter;

    List<Startup> startupList;
    StartupDatabase startupDatabase;
    SearchView searchView;

//    public void getStartupRecyclerView(RecyclerView recyclerView){
//        this.recyclerView=recyclerView;
//    }


    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startupList = new ArrayList<>();


        SQLiteDatabase Project = getActivity().openOrCreateDatabase("ProjectApp1",android.content.Context.MODE_PRIVATE ,null);
        startupDatabase=new StartupDatabase(Project);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_startup, container, false);
        //recyclerView= new MainActivity2().recyclerView;
        recyclerView =  view.findViewById(R.id.recyclerView);

        initData();
        initRecyclerView();




        return view;
    }
    void initRecyclerView(){
        //recyclerView= new MainActivity2().recyclerView;
        StartupAdapter startupAdapter=new StartupAdapter(startupList);
        recyclerView.setAdapter(startupAdapter);
//        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);


    }
    void initData(){


        Cursor c=startupDatabase.Project.rawQuery("SELECT * FROM startups",null);

        int nameIndex=c.getColumnIndex("name");
        int shortDescIndex=c.getColumnIndex("shortDesc");
        int startupIdeaIndex=c.getColumnIndex("startupIdea");
        int qualificationIndex=c.getColumnIndex("qualification");
        int locationIndex=c.getColumnIndex("location");
        int emailIndex=c.getColumnIndex("email");
        int phoneIndex=c.getColumnIndex("phone");

        c.moveToFirst();

        while(!c.isAfterLast()){
            startupList.add(new Startup(c.getString(nameIndex),c.getString(shortDescIndex),c.getString(startupIdeaIndex),c.getString(qualificationIndex),c.getString(locationIndex),c.getString(emailIndex),c.getString(phoneIndex)));

            c.moveToNext();
        }

//        startupList.add(new Startup("1","1","1","1","1","1","1"));
//        startupList.add(new Startup("1","1","1","1","1","1","1"));
//        startupList.add(new Startup("1","1","1","1","1","1","1"));
//        startupList.add(new Startup("1","1","1","1","1","1","1"));
//        startupList.add(new Startup("1","1","1","1","1","1","1"));
//
//        add multiple
//        this.name=name;
//        this.shortDesc=shortDesc;
//        this.startupIdea=startupIdea;
//        this.qualification=qualification;
//        this.location=location;
//        this.email=email;
//        this.phone=phone;


    }
}
