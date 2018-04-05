package com.example.sabarishnandha.intelligentcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminPage extends AppCompatActivity {
DatabaseHelper mydb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
    mydb1=new DatabaseHelper(this);

    }
    public void adminclick(View v)
    {

        Intent i8=new Intent(AdminPage.this,LoginActivity_Admin.class);
        startActivity(i8);

    }

    public void userclick(View v)
    {
        Intent i9=new Intent(AdminPage.this,MainActivity.class);
        startActivity(i9);
    }



}
