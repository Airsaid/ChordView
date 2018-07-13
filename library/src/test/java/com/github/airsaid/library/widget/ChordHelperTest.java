package com.github.airsaid.library.widget;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author airsaid
 */
public class ChordHelperTest {

    private List<Chord> mChords;
    private ChordHelper mChordHelper;

    @Before
    public void setUp() throws Exception {
        mChordHelper = new ChordHelper();
        mChords = new ArrayList<>();
        mChords.add(new Chord(new int[]{-1, 3, 2, 0, 1, 0}, new int[]{3, 4, 2, 0, 1, 0}));  // C1
        mChords.add(new Chord(new int[]{3, 3, 5, 5, 5, 3}, new int[]{1, 1, 2, 3, 4, 1}));   // C2
        mChords.add(new Chord(new int[]{-1, 7, 5, 5, 5, 8}, new int[]{0, 3, 1, 1, 1, 4}));  // C3
        mChords.add(new Chord(new int[]{8, 10, 10, 9, 8, 8}, new int[]{1, 3, 4, 2, 1, 1})); // C4
        mChords.add(new Chord(new int[]{-1, -1, 1, 0, 1, 3}, new int[]{0, 0, 1, 0, 2, 4})); // Cm
        mChords.add(new Chord(new int[]{-1, -1, 1, 2, 1, 2}, new int[]{0, 0, 1, 3, 2, 4})); // Cdim
        mChords.add(new Chord(new int[]{-1, 3, 3, 0, 1, 1}, new int[]{0, 3, 4, 0, 1, 1}));  // Csus4
    }

    @Test
    public void getBarreChordData() throws Exception {
        assertThat(mChordHelper.getBarreChordData(mChords.get(0)), nullValue());
        assertThat(mChordHelper.getBarreChordData(mChords.get(1)), is(new int[]{3, 6}));
        assertThat(mChordHelper.getBarreChordData(mChords.get(2)), is(new int[]{5, 5}));
        assertThat(mChordHelper.getBarreChordData(mChords.get(3)), is(new int[]{8, 6}));
        assertThat(mChordHelper.getBarreChordData(mChords.get(4)), nullValue());
        assertThat(mChordHelper.getBarreChordData(mChords.get(5)), is(new int[]{1, 4}));
        assertThat(mChordHelper.getBarreChordData(mChords.get(6)), is(new int[]{1, 2}));
    }

    @Test
    public void firstStringLeast() throws Exception {
        assertThat(mChordHelper.firstStringLeast(mChords.get(0)), is(false));
        assertThat(mChordHelper.firstStringLeast(mChords.get(1)), is(true));
        assertThat(mChordHelper.firstStringLeast(mChords.get(2)), is(false));
        assertThat(mChordHelper.firstStringLeast(mChords.get(3)), is(true));
    }

    @Test
    public void getWithFirstString() throws Exception {
        assertThat(mChordHelper.getWithFirstString(mChords.get(0)), is(1));
        assertThat(mChordHelper.getWithFirstString(mChords.get(1)), is(1));
        assertThat(mChordHelper.getWithFirstString(mChords.get(2)), is(1));
        assertThat(mChordHelper.getWithFirstString(mChords.get(3)), is(2));
    }

    @Test
    public void getMaxUnClosedString() throws Exception {
        assertThat(mChordHelper.getMaxUnClosedString(mChords.get(0)), is(5));
        assertThat(mChordHelper.getMaxUnClosedString(mChords.get(1)), is(6));
        assertThat(mChordHelper.getMaxUnClosedString(mChords.get(2)), is(5));
        assertThat(mChordHelper.getMaxUnClosedString(mChords.get(3)), is(6));
    }

}