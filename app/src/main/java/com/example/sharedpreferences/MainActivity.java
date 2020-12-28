package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {

    private EditText mName , mPassword ;
    private Button btmLogin ;
    private CheckBox mCheckBox ;
    private SharedPreferences mPref ;
    private SharedPreferences.Editor mEditor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     mName=findViewById(R.id.editTextTextPersonName)   ;
     mPassword=findViewById(R.id.editTextNumberPassword);
        btmLogin=findViewById(R.id.button);
        mCheckBox=findViewById(R.id.checkBox);

         mPref=getSharedPreferences("com.example.sharedpreferences" , Context.MODE_PRIVATE) ;
           mEditor =mPref.edit() ;
        checkSharedPreferences() ;
        btmLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckBox.isChecked()){
                    mEditor.putString(getString(R.string.checkbox),"True");
                    mEditor.commit() ;
                    String name =mName.getText().toString();
                    mEditor.putString(getString(R.string.name),name);
                    mEditor.commit() ;
                    String password =mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password),password);
                    mEditor.commit() ;

                }else {

                    mEditor.putString(getString(R.string.checkbox),"False");
                    mEditor.commit() ;

                    mEditor.putString(getString(R.string.name),"");

                    mEditor.putString(getString(R.string.password),"");
                    mEditor.commit() ;
                }
            }
        });

    }

    private void  checkSharedPreferences(){


        String checkbox=mPref.getString(getString(R.string.checkbox),"False");
        String name=mPref.getString("name","");
        String password=mPref.getString(getString(R.string.password),"");
        mName.setText(name);
        mPassword.setText(password);
        if(checkbox.equals("True")){
            mCheckBox.setChecked(true);
        }else {
            mCheckBox.setChecked(false);
        }

    }
}

