package com.example.project;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, phone, password;
    Button register;
    TextView login;
    boolean isNameValid, isEmailValid, isPhoneValid, isPasswordValid;
    TextInputLayout nameError, emailError, phoneError, passError;


    SQLiteDatabase Project;
    ContentValues initialValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        login = (TextView) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        //nameError = (TextInputLayout) findViewById(R.id.nameError);
        emailError = (TextInputLayout) findViewById(R.id.emailError);
        phoneError = (TextInputLayout) findViewById(R.id.phoneError);
        passError = (TextInputLayout) findViewById(R.id.passError);

        Project = this.openOrCreateDatabase("ProjectApp1",android.content.Context.MODE_PRIVATE ,null);
        Project.execSQL("CREATE TABLE IF NOT EXISTS registered(email VARCHAR,phone VARCHAR,password VARCHAR)");


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to LoginActivity
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void SetValidation() {
        // Check for a valid name.
//        if (name.getText().toString().isEmpty()) {
//            nameError.setError(getResources().getString(R.string.name_error));
//            isNameValid = false;
//        } else  {
//            isNameValid = true;
//            nameError.setErrorEnabled(false);
//        }

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

        // Check for a valid phone number.
        if (phone.getText().toString().isEmpty()) {
            phoneError.setError(getResources().getString(R.string.phone_error));
            isPhoneValid = false;
        } else  {
            isPhoneValid = true;
            phoneError.setErrorEnabled(false);
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

        if (isEmailValid && isPhoneValid && isPasswordValid) {

            initialValues = new ContentValues();

            initialValues.put("password", password.getText().toString());
            initialValues.put("email", email.getText().toString());
            initialValues.put("phone", phone.getText().toString());

            Project.insert("registered",null,initialValues);

            Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_LONG).show();

            Intent i=new Intent(RegisterActivity.this,
                    MainActivity2.class);
            startActivity(i);

            finish();
        }

    }

}
