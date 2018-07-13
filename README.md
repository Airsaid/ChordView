# ChordView
Android custom View for rendering guitar chord.

# Preview
![image](https://github.com/Airsaid/Chord/blob/master/preview.gif)

# Use
Layout:

``` xml
 <com.github.airsaid.chordview.widget.ChordView
        android:id="@+id/chordView"
        android:layout_width="240dp"
        android:layout_height="300dp"
        app:cv_barreAlpha="200"
        app:cv_barreColor="@android:color/white"
        app:cv_barreStrokeColor="@android:color/white"
        app:cv_barreStrokeWidth="2dp"
        app:cv_closedStringImage="@mipmap/ic_closed_string"
        app:cv_emptyStringImage="@mipmap/ic_empty_string"
        app:cv_fretTextColor="@android:color/darker_gray"
        app:cv_fretTextOffsetX="10dp"
        app:cv_fretTextSize="12sp"
        app:cv_gridLineColor="@android:color/white"
        app:cv_gridLineWidth="3dp"
        app:cv_headColor="@android:color/white"
        app:cv_headRadius="20dp"
        app:cv_noteAlpha="200"
        app:cv_noteColor="@android:color/white"
        app:cv_noteRadius="16dp"
        app:cv_noteStrokeColor="@android:color/white"
        app:cv_noteStrokeWidth="2dp"
        app:cv_noteTextColor="@android:color/black"
        app:cv_noteTextSize="16sp"
        app:cv_stringOffsetY="10dp" />
```

Code:

``` java
Chord chord = new Chord(new int[]{-1, 3, 2, 0, 1, 0}, new int[]{0, 3, 2, 0, 1, 0});
mChordView.setChord(chord);
```

# ContactMe
- Blog: [https://airsaid.com/](https://airsaid.com/)
- Telegram: [https://t.me/airsaids/](https://t.me/airsaids/)
