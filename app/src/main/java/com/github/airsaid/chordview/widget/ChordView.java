package com.github.airsaid.chordview.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * 用于渲染吉他和铉的 Android 自定义 View。
 *
 * @author airsaid
 */
public class ChordView extends View {

    public ChordView(Context context) {
        super(context);
    }

    public ChordView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ChordView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
