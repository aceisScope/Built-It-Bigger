package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.binghui.libjokedisplay.JokeDisplayActivity;
import com.example.Joker;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String s) {
                handleJokeServiceResponse(s);
            }
        }.execute();
    }

    @VisibleForTesting
    public void handleJokeServiceResponse(String s) {
        if (s != null) {
            Intent intent = new Intent(MainActivity.this, JokeDisplayActivity.class);
            intent.putExtra("joke", s);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "There's a problem getting the joke :(", Toast.LENGTH_SHORT).show();
        }
    }
}
