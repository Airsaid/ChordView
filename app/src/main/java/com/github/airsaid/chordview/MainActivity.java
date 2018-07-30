package com.github.airsaid.chordview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.github.airsaid.library.widget.Chord;
import com.github.airsaid.library.widget.ChordView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ChordView mChordView;
    private List<Chord> mChords;
    private int mIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChordView = findViewById(R.id.chordView);
        RadioGroup mode = findViewById(R.id.mode);
        mode.setOnCheckedChangeListener(this);

        mChords = new ArrayList<>();
        mChords.add(new Chord(new int[]{-1, 3, 2, 0, 1, 0}, new int[]{0, 3, 2, 0, 1, 0}));
        mChords.add(new Chord(new int[]{3, 3, 5, 5, 5, 3}, new int[]{1, 1, 2, 3, 4, 1}));
        mChords.add(new Chord(new int[]{-1, 7, 5, 5, 5, 8}, new int[]{0, 3, 1, 1, 1, 4}));
        mChords.add(new Chord(new int[]{8, 10, 10, 9, 8, 8}, new int[]{1, 3, 4, 2, 1, 1}));
        mChords.add(new Chord(new int[]{-1, -1, 1, 0, 1, 3}, new int[]{0, 0, 1, 0, 2, 4}));
        mChords.add(new Chord(new int[]{-1, -1, 1, 2, 1, 2}, new int[]{0, 0, 1, 3, 2, 4}));
        mChords.add(new Chord(new int[]{-1, 3, 3, 0, 1, 1}, new int[]{0, 2, 3, 0, 1, 1}));
        mChordView.setChord(mChords.get(mIndex));

        Chord chord = new Chord(new int[]{-1, 3, 2, 0, 1, 0}, new int[]{0, 3, 2, 0, 1, 0});
        mChordView.setChord(chord);
    }

    public void onPrev(View v) {
        mIndex--;
        if (mIndex < 0) {
            mIndex = mChords.size() - 1;
        }
        mChordView.setChord(mChords.get(mIndex));
    }

    public void onNext(View v) {
        mIndex++;
        if (mIndex >= mChords.size()) {
            mIndex = 0;
        }
        mChordView.setChord(mChords.get(mIndex));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.normal) {
            mChordView.setShowMode(ChordView.NORMAL_SHOW_MODE);
        } else {
            mChordView.setShowMode(ChordView.SIMPLE_SHOW_MODE);
        }
    }
}
