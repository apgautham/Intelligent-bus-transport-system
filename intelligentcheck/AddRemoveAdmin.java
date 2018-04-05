package com.example.sabarishnandha.intelligentcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddRemoveAdmin extends AppCompatActivity {
String m;
String[] n={"1000","1001","1002","1003","1004","1005","1006"};
    AutoCompleteTextView ac;int i,flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remove_admin);
        ac=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        String[] words=getResources().getStringArray(R.array.check);
        ArrayAdapter<String> ad=new ArrayAdapter<String>(AddRemoveAdmin.this,android.R.layout.simple_list_item_1,words);
        ac.setAdapter(ad);
        flag=0;
        List<String> list = new ArrayList<String>(Arrays.asList(n));
    }

    public void addclick(View v)
    {
        m=ac.getText().toString();
        for(i=0;i<7;i++)
        {
            if(n[i].equals(m))
            flag=1;
        }
        if(flag==1) {
            Toast.makeText(AddRemoveAdmin.this, "Already Present.....", Toast.LENGTH_LONG).show();
        flag=0;
        }
        else
        Toast.makeText(AddRemoveAdmin.this,"Successfully added",Toast.LENGTH_LONG).show();
    }

    public void removeclick(View v)
    {
        m=ac.getText().toString();
        for(i=0;i<7;i++)
    {
        if(n[i].equals(m))
            flag=1;
    }
    if(flag==1) {
     flag=0;
        Toast.makeText(AddRemoveAdmin.this, "Your bus has been removed", Toast.LENGTH_LONG).show();
    }
    else
        Toast.makeText(AddRemoveAdmin.this, "The given bus is not present", Toast.LENGTH_LONG).show();
    }

    public void homeclick(View v)
    {
        Intent i12=new Intent(AddRemoveAdmin.this,AdminPage.class);
        startActivity(i12);
    }


}
