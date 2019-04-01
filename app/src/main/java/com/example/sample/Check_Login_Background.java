package com.example.sample;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class Check_Login_Background extends AsyncTask
{
    public Context context;
    public TextView status;
    public Check_Login_Background(Context context, TextView status)
    {
        this.context = context;
        this.status = status;
    }


    protected void onPreExecute(){
    }

    @Override
    protected Object doInBackground(Object[] objects)
    {
        String username = ((EditText)objects[0]).getText().toString();
        String password = ((EditText)objects[1]).getText().toString();
        try {
            //URL url = new URL("http://localhost/dashboard/android_api/login_check.php?username=" +username + "&&password=" + password + "");
            URL url = new URL("http://192.168.43.22/dashboard/android_api/login_check.php?username=" +username + "&&password=" + password + "");
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI("http://192.168.43.22/dashboard/android_api/login_check.php?username=" +username + "&&password=" + password + ""));


            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));


            StringBuffer sb = new StringBuffer("");
            String line = "";

            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }

            in.close();
            return sb.toString();
        }
        catch(Exception exception)
        {

            return "Exception "+exception.toString();
        }


    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        this.status.setText(o.toString()+" Response");
    }
}
