package com.example.sabarishnandha.intelligentcheck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.MonthDisplayHelper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayFinal extends AppCompatActivity {

DatabaseHelper mydb;
    String mainname=" ";
    String mobilenumber=" ";
    String seatbook=" ";
    String selectseats=" ";
    String source=" ";
    String destination=" ";
Button b1;
  TextView v1;
       TextView v2;
       TextView v3;
    TextView v4;
   TextView v5;
      TextView v6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_final);
        mydb=new DatabaseHelper(this);
b1=(Button)findViewById(R.id.button5);
           v1=(TextView)findViewById(R.id.textView15);
          v2=(TextView)findViewById(R.id.textView16);
        v3=(TextView)findViewById(R.id.textView17);
        v4=(TextView)findViewById(R.id.textView18);
        v5=(TextView)findViewById(R.id.textView19);
        v6=(TextView)findViewById(R.id.textView20);
        SharedPreferences get=getSharedPreferences("sp",MODE_PRIVATE);
        SharedPreferences get1=getSharedPreferences("sp1",MODE_PRIVATE);
        SharedPreferences get2=getSharedPreferences("sp2",MODE_PRIVATE);
        mainname=get1.getString("name","Gautham");
        mobilenumber=get1.getString("mobilenumber","9876689090");
        seatbook=get2.getString("totalseats","");
       selectseats=get2.getString("selectseats","");
        source=get.getString("source","madurai");
       destination=get.getString("destination","chennai");
mydb.insertData(mobilenumber,mainname,source,destination,seatbook,selectseats,selectseats,"7");
      //  mydb.insertData(455,"hello","madurai","chennai",1,"S3",1500,5);
         v1.setText(mainname);
        v2.setText(mobilenumber);
        v3.setText(seatbook);
        v4.setText(selectseats);
        v5.setText(source);
        v6.setText(destination);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(DisplayFinal.this,"came issie",Toast.LENGTH_SHORT).show();
        Intent i6=new Intent(DisplayFinal.this,MapsActivity.class);
        Toast.makeText(DisplayFinal.this,"intent created",Toast.LENGTH_SHORT).show();
        startActivity(i6);
        Toast.makeText(DisplayFinal.this,"intent passed",Toast.LENGTH_SHORT).show();
    }
});

    }




}
