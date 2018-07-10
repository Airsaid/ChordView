package com.github.airsaid.chordview.widget;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author airsaid
 */
public class ChordTest {

    private List<Chord> mChords;

    @Before
    public void setUp() throws Exception {
        mChords = new ArrayList<>();
        mChords.add(new Chord(new int[]{3, 3, 2, 0, 1, 0}, new int[]{3, 4, 2, 0, 1, 0}));   // C1
        mChords.add(new Chord(new int[]{3, 3, 5, 5, 5, 3}, new int[]{1, 1, 2, 3, 4, 1}));   // C2
        mChords.add(new Chord(new int[]{-1, 7, 5, 5, 5, 8}, new int[]{0, 3, 1, 1, 1, 4}));  // C3
        mChords.add(new Chord(new int[]{8, 10, 10, 9, 8, 8}, new int[]{1, 3, 4, 2, 1, 1})); // C4
    }

    @Test
    public void isEmptyString() throws Exception {
        // 测试包含空弦的和弦
        assertThat(mChords.get(0).isEmptyString(), is(true));
        // 测试不包含空弦的和弦
        assertThat(mChords.get(1).isEmptyString(), is(false));
    }

    @Test
    public void isClosedString() throws Exception {
        // 测试包含闭弦的和弦
        assertThat(mChords.get(2).isClosedString(), is(true));
        // 测试不包含闭弦的和弦
        assertThat(mChords.get(3).isClosedString(), is(false));
    }

    @Test
    public void getLeastFret() throws Exception {
        // 测试和弦中的最小品
        assertThat(mChords.get(0).getLeastFret(), is(1));
        assertThat(mChords.get(1).getLeastFret(), is(3));
        assertThat(mChords.get(2).getLeastFret(), is(5));
        assertThat(mChords.get(3).getLeastFret(), is(8));
    }

}