package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {


        EditText email, password;
        Button login;
        TextView register;
        boolean isEmailValid, isPasswordValid;
        TextInputLayout emailError, passError;
        SQLiteDatabase Project;
        View view;
        TextView nameTextView,emailTextView,phoneTextView,locationTextView,qualificationTextView,shortDescTextView,startupIdeaTextView;
        static boolean loginFlag=false;
        static String emailValue;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);

            email = (EditText) findViewById(R.id.email);
            password = (EditText) findViewById(R.id.password);
            login = (Button) findViewById(R.id.login);
            register = (TextView) findViewById(R.id.register);
            emailError = (TextInputLayout) findViewById(R.id.emailError);
            passError = (TextInputLayout) findViewById(R.id.passError);
            Project = this.openOrCreateDatabase("ProjectApp1", android.content.Context.MODE_PRIVATE, null);
           // view = inflater.inflate(R.layout.fragment_profile, container, false);


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SetValidation();
                }
            });

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // redirect to RegisterActivity
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(intent);
                }
            });
        }


        public void SetValidation() {
            // Check for a valid email address.
            if (email.getText().toString().isEmpty()) {
                emailError.setError(getResources().getString(R.string.email_error));
                isEmailValid = false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                emailError.setError(getResources().getString(R.string.error_invalid_email));
                isEmailValid = false;
            } else  {
                isEmailValid = true;
                emailError.setErrorEnabled(false);
            }

            // Check for a valid password.
            if (password.getText().toString().isEmpty()) {
                passError.setError(getResources().getString(R.string.password_error));
                isPasswordValid = false;
            } else if (password.getText().length() < 6) {
                passError.setError(getResources().getString(R.string.error_invalid_password));
                isPasswordValid = false;
            } else  {
                isPasswordValid = true;
                passError.setErrorEnabled(false);
            }

            if (isEmailValid && isPasswordValid) {
               // Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();

                emailValue = email.getText().toString();
                String passwordValue = password.getText().toString();
                Cursor c = Project.rawQuery("SELECT * FROM registered WHERE email= ?", new String[]{emailValue});

                if (c != null && c.getCount() > 0) {
                    int passwordIndex = c.getColumnIndex("password");
                    c.moveToFirst();
                    String truePassword = c.getString(passwordIndex);
                    if (passwordValue.equals(truePassword)) {
                        Intent i=new Intent(LoginActivity.this,
                                MainActivity2.class);
                        startActivity(i);
                        finish();
                        loginFlag=true;
                        //setProfile();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Incorrect Password ", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "email is not registered", Toast.LENGTH_LONG).show();
                }


            }

        }

//

    }
