package com.example.displayjoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        TextView jtv = findViewById(R.id.jokeTextView);
        Intent intent = getIntent();
        String joke="";

        if(intent.hasExtra("joke"))
            joke = intent.getStringExtra("joke");

        jtv.setText(joke);
    }

}
