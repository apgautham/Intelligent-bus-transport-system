package com.example.sabarishnandha.intelligentcheck;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    Calendar myCalendar;

    EditText edittext;
    AutoCompleteTextView edittext2,edittext3;
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };



    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCalendar = Calendar.getInstance();
        edittext= (EditText) findViewById(R.id.Birthday);
        edittext2= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        edittext3= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView3);

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        String[] word=getResources().getStringArray(R.array.auto_complete);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,word);
        edittext2.setAdapter(adapter);
        edittext3.setAdapter(adapter);


    }

    public void goclick(View v)
    {
       // Toast.makeText(MainActivity.this, edittext2.getText().toString(), Toast.LENGTH_SHORT).show();
      //  Toast.makeText(MainActivity.this, edittext3.toString(), Toast.LENGTH_SHORT).show();
        SharedPreferences sp=getSharedPreferences("sp",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("date",edittext.getText().toString());
        editor.putString("source",edittext2.getText().toString());
        editor.putString("destination",edittext3.getText().toString());
        editor.commit();
        Intent i=new Intent(MainActivity.this,SearchActivity.class);
        startActivity(i);
    }


}
