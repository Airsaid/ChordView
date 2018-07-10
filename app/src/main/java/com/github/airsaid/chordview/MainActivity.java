package com.github.airsaid.chordview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.airsaid.chordview.widget.ChordView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] c = {"s3", "3", "2", "0", "1", "0"};// 品
        String[] c2 = {"3", "4", "2", "", "1", ""};// 指法
        ChordView chordView = findViewById(R.id.chordView);

    }
}
