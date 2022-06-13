package com.example.project;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InvestorFragment extends Fragment {


    RecyclerView recyclerView;
    List<Investor> investorList;
    InvestorDatabase investorDatabase;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        investorList = new ArrayList<>();


        SQLiteDatabase Project = getActivity().openOrCreateDatabase("ProjectApp1",android.content.Context.MODE_PRIVATE ,null);
        investorDatabase= new InvestorDatabase(Project);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_investor, container, false);

          recyclerView =  view.findViewById(R.id.recyclerView);

          initData();
          initRecyclerView();
          return view;
    }

    void initRecyclerView(){
        //recyclerView= new MainActivity2().recyclerView;
        InvestorAdapter investorAdapter=new InvestorAdapter(investorList);
        recyclerView.setAdapter(investorAdapter);
//        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);


    }
    void initData(){


        Cursor c=investorDatabase.Project.rawQuery("SELECT * FROM investors",null);

        int nameIndex=c.getColumnIndex("name");
        int investmentIndex=c.getColumnIndex("investment");
        int ideaPreferencesIndex=c.getColumnIndex("ideaPreferences");
        int qualificationIndex=c.getColumnIndex("qualification");
        int emailIndex=c.getColumnIndex("email");
        int phoneIndex=c.getColumnIndex("phone");

        c.moveToFirst();

        while(!c.isAfterLast()){
            investorList.add(new Investor(c.getString(nameIndex),c.getString(investmentIndex),c.getString(ideaPreferencesIndex),c.getString(qualificationIndex),c.getString(emailIndex),c.getString(phoneIndex)));

            c.moveToNext();
        }


//        investorList.add(new Investor("1","1","1","1","1","1"));
//        investorList.add(new Investor("1","1","1","1","1","1"));
//        investorList.add(new Investor("1","1","1","1","1","1"));
//        investorList.add(new Investor("1","1","1","1","1","1"));
//        investorList.add(new Investor("1","1","1","1","1","1"));
//        //add multiple
    }
}
