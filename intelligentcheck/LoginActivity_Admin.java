package com.example.sabarishnandha.intelligentcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity_Admin extends AppCompatActivity {
String a,b;
    EditText et1,et2;
    String[] user={"gautham","anbu","navin"};
    String[] pass={"gautham","anbu","navin"};
    int i,j,flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__admin);
        flag=0;
        et1=(EditText)findViewById(R.id.editText10);
        et2=(EditText)findViewById(R.id.editText12);

    }

    public void signclick(View v)
    {
        a=et1.getText().toString();
        b=et2.getText().toString();
        for(i=0;i<3;i++)
        {
            if(a.equals(user[i]))
            {
                if(b.equals(pass[i]))
                    flag=1;
            }

        }

        if(flag==1) {
            Intent i11 = new Intent(LoginActivity_Admin.this, AddRemoveAdmin.class);
            startActivity(i11);
        }
        else
            Toast.makeText(LoginActivity_Admin.this,"UserName or password incorrect",Toast.LENGTH_SHORT).show();
    }

}
