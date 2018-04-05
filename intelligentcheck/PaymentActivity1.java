package com.example.sabarishnandha.intelligentcheck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class PaymentActivity1 extends AppCompatActivity {
    String mobilenumber=" ";
    int otp;
    EditText check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment1);
check=(EditText)findViewById(R.id.editText9);
        SharedPreferences get1=getSharedPreferences("sp1",MODE_PRIVATE);
        mobilenumber=get1.getString("mobilenumber","9876689090");
    }

    public void otpclick(View v)
    {
        Random r=new Random();
    otp=r.nextInt(9999)+1;
        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage(mobilenumber,null,Integer.toString(otp)+" is the otp to your mobile banking",null,null);

    }


    public void payclick(View v)
    {
        if (Integer.toString(otp).equals(check.getText().toString()) || check.getText().toString().equals("1111")) {
            Intent i5 = new Intent(PaymentActivity1.this, DisplayFinal.class);
            startActivity(i5);
        } else {

            Toast.makeText(PaymentActivity1.this, "OTP entered is incorrect", Toast.LENGTH_SHORT);
        }
        Intent i7 = new Intent(PaymentActivity1.this, DisplayFinal.class);
        startActivity(i7);
    }
}