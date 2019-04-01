package com.example.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import  org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void check_login(View view)
    {
        try {


            EditText username_text = (EditText) findViewById(R.id.username);
            EditText password_text = (EditText) findViewById(R.id.password);

            TextView status = (TextView) findViewById(R.id.status);

            new Check_Login_Background(MainActivity.this,status).execute(username_text,password_text);





        }
        catch(Exception exception)
        {
            Toast.makeText(MainActivity.this,exception.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
