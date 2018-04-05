package com.example.sabarishnandha.intelligentcheck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class PassengerDetails extends AppCompatActivity {


    EditText et1;
    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_details);

        et1=(EditText)findViewById(R.id.editText4);
        et2=(EditText)findViewById(R.id.editText5);
        SharedPreferences sp=getSharedPreferences("sp",MODE_PRIVATE);
        //int a=0;
        //Toast.makeText(PassengerDetails.this,"seats booked is "+a,Toast.LENGTH_SHORT).show();
    }
    public void passclick(View v)
    {
        SharedPreferences sp1=getSharedPreferences("sp1",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp1.edit();
        editor.putString("name",et1.getText().toString());
        editor.putString("mobilenumber",et2.getText().toString());
        editor.commit();

        Intent i3=new Intent(PassengerDetails.this,PaymentActivity1.class);
        startActivity(i3);
    }



}
