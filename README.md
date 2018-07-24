<p align="center"><img src="app/src/main/res/drawable/logotype.png" alt="Proje ismi" height="50px"></p>

# ChordView
Android custom View for rendering guitar chord.

# Preview
![image](https://github.com/Airsaid/ChordView/blob/master/preview.gif)

# Usage
1. Added to app/build.gradle:
```
implementation 'com.github.airsaid:chordview:0.0.2'
```


2. Layout:

``` xml
 <com.github.airsaid.library.widget.ChordView
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

3. Code:

``` java
Chord chord = new Chord(new int[]{-1, 3, 2, 0, 1, 0}, new int[]{0, 3, 2, 0, 1, 0});
mChordView.setChord(chord);
```

# ContactMe
- Blog: [https://airsaid.com/](https://airsaid.com/)
- Telegram: [https://t.me/airsaids/](https://t.me/airsaids/)

# License
```
Copyright 2018 Airsaid. https://github.com/airsaid

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
