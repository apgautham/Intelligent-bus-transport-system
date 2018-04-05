package com.example.sabarishnandha.intelligentcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
    public void imageclick(View v)
    {
        Intent i1=new Intent(SearchActivity.this,BusLayoutActivity.class);
        startActivity(i1);
    }
}
