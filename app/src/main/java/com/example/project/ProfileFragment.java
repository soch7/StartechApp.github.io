package com.example.project;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project.R;

import java.util.ArrayList;



public class ProfileFragment extends Fragment {


    String name,email,phone,qualification,location,shortDesc,startupIdea,investment,ideaPreferences,category;
    StartupDatabase startupDatabase;
    InvestorDatabase investorDatabase;
    SQLiteDatabase Project;
    Button register;
    TextView nameTextView,emailTextView,phoneTextView,locationTextView,qualificationTextView,shortDescTextView,startupIdeaTextView;
    TextView investmentTextView,ideaPreferencesTextView,categoryTextView,registerTextView,register2TextView;
    Cursor c1,c2;

    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Project = getActivity().openOrCreateDatabase("ProjectApp1",android.content.Context.MODE_PRIVATE ,null);


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        register = (Button) view.findViewById(R.id.registerButton);



//        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.groupradio);
//        int radioButtonID = radioGroup.getCheckedRadioButtonId();
//        RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);
//         String category = (String) radioButton.getText();

        ////
        nameTextView=(TextView)view.findViewById(R.id.nameTextView);
        emailTextView=(TextView)view.findViewById(R.id.emailTextView);
        phoneTextView=(TextView)view.findViewById(R.id.phoneTextView);
        locationTextView=(TextView)view.findViewById(R.id.locationTextView);
        qualificationTextView=(TextView)view.findViewById(R.id.qualificationTextView);
        shortDescTextView=(TextView)view.findViewById(R.id.shortDescTextView);
        startupIdeaTextView=(TextView)view.findViewById(R.id.startupIdeaTextView);
        investmentTextView=(TextView)view.findViewById(R.id.investmentTextView);
        ideaPreferencesTextView=(TextView)view.findViewById(R.id.ideaPreferencesTextView);
        categoryTextView=(TextView)view.findViewById(R.id.categoryTextView);
        registerTextView=(TextView)view.findViewById(R.id.registerTextView);
        register2TextView=(TextView)view.findViewById(R.id.register2TextView);


        if (Boolean.compare(LoginActivity.loginFlag, true)==0)
        {setProfile();}

        ////


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("check","onclick running");
                name =  (nameTextView).getText().toString();
                email =  (emailTextView).getText().toString();
                phone =  (phoneTextView).getText().toString();
                qualification =  (qualificationTextView).getText().toString();
                location=  (locationTextView).getText().toString();
                shortDesc =  (shortDescTextView).getText().toString();
                investment =  (investmentTextView).getText().toString();
                ideaPreferences =  (ideaPreferencesTextView).getText().toString();
                startupIdea =  (startupIdeaTextView).getText().toString();
                category =  (categoryTextView).getText().toString();



                if(category.equalsIgnoreCase("Startup"))
                {
                    startupDatabase=new StartupDatabase(Project,name,shortDesc,startupIdea,qualification,location,email,phone);
                    startupDatabase.Insert();
                    Log.i("category","Startup");
                }
                if(category.equalsIgnoreCase("Investor"))
                {
                    investorDatabase=new InvestorDatabase(Project,name,investment,ideaPreferences,qualification,email,phone);
                    investorDatabase.Insert();
                    Log.i("category","Investor");
                }

            }
        });



        return view;
    }
    public void setProfile() {


         registerTextView.setText("Profile : ");
         register2TextView.setVisibility(View.INVISIBLE);
         register.setVisibility(View.INVISIBLE);
          c1=Project.rawQuery("SELECT * FROM startups where email=?",new String[]{LoginActivity.emailValue});
        c2 = Project.rawQuery("SELECT * FROM investors where email=?", new String[]{LoginActivity.emailValue});

        if (c1 != null && c1.getCount() > 0) {

              int nameIndex = c1.getColumnIndex("name");
              int shortDescIndex = c1.getColumnIndex("shortDesc");
              int startupIdeaIndex = c1.getColumnIndex("startupIdea");
              int qualificationIndex = c1.getColumnIndex("qualification");
              int locationIndex = c1.getColumnIndex("location");
              //int emailIndex=c1.getColumnIndex("email");
              int phoneIndex = c1.getColumnIndex("phone");

              c1.moveToFirst();
              String dbName = c1.getString(nameIndex);
              String dbShortDesc = c1.getString(shortDescIndex);
              String dbStartupIdea = c1.getString(startupIdeaIndex);
              String dbQualification = c1.getString(qualificationIndex);
              String dbLocation = c1.getString(locationIndex);
              String dbPhone = c1.getString(phoneIndex);

              nameTextView.setText(dbName);
              emailTextView.setText(LoginActivity.emailValue);
              phoneTextView.setText(dbPhone);
              locationTextView.setText(dbLocation);
              qualificationTextView.setText(dbQualification);
              shortDescTextView.setText(dbShortDesc);
              startupIdeaTextView.setText(dbStartupIdea);
              categoryTextView.setText("Startup");
          }
          //if (c2 != null && c2.getCount() > 0) {
          else if (c2 != null && c2.getCount() > 0) {
                  int nameIndex = c2.getColumnIndex("name");
                  int investmentIndex = c2.getColumnIndex("investment");
                  int ideaPreferencesIndex = c2.getColumnIndex("ideaPreferences");
                  int qualificationIndex = c2.getColumnIndex("qualification");
                  //int emailIndex=c2.getColumnIndex("email");
                  int phoneIndex = c2.getColumnIndex("phone");

                  c2.moveToFirst();
                  String dbName = c2.getString(nameIndex);
                  String dbInvestment = c2.getString(investmentIndex);
                  String dbIdeaPreferences = c2.getString(ideaPreferencesIndex);
                  String dbQualification = c2.getString(qualificationIndex);
                  String dbPhone = c2.getString(phoneIndex);

                  nameTextView.setText(dbName);
                  emailTextView.setText(LoginActivity.emailValue);
                  phoneTextView.setText(dbPhone);
                  ideaPreferencesTextView.setText(dbIdeaPreferences);
                  qualificationTextView.setText(dbQualification);
                  investmentTextView.setText(dbInvestment);
                  categoryTextView.setText("Investor");

              }
          }

    }



