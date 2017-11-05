package com.binghui.libjokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        String joke = getIntent().getStringExtra("joke");
        if (joke != null) {
            TextView textView = (TextView) findViewById(R.id.text_joke);
            textView.setText(joke);
        }
    }
}
