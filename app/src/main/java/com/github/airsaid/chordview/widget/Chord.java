package com.github.airsaid.chordview.widget;

import java.util.Arrays;

/**
 * 和铉。根据规则，当品数据为 -1 时表示闭弦，为 0 时表示空弦。
 *
 * @author airsaid
 */
public class Chord {

    /** 最大有 6 根弦（这个常量的定义是避免后续其他吉他弦数不同问题，不过按照面向对象思想该常量应该放到吉他对象中） */
    private static final int MAX_STRING = 6;

    /** 品 */
    private int[] frets;
    /** 指法 */
    private int[] fingers;

    public Chord(int[] frets, int[] fingers) {
        this.frets = frets;
        this.fingers = fingers;
    }

    public int[] getFrets() {
        return frets;
    }

    public void setFrets(int[] frets) {
        this.frets = frets;
    }

    public int[] getFingers() {
        return fingers;
    }

    public void setFingers(int[] fingers) {
        this.fingers = fingers;
    }

    /**
     * 返回该和铉中是否有空弦。
     *
     * @return 当该和弦中有空弦时则返回 true，否则返回 false。
     */
    public boolean isEmptyString() {
        for (int fret : frets) {
            if (fret == 0) return true;
        }
        return false;
    }

    /**
     * 返回该和铉中是否有闭弦。
     *
     * @return 当该和弦中有闭弦时则返回 true，否则返回 false
     */
    public boolean isClosedString() {
        for (int fret : frets) {
            if (fret == -1) return true;
        }
        return false;
    }

    /**
     * 获取当前和弦中最小的品。
     *
     * @return 最小品，当没有找到时会返回 -1。（这种情况一般不会出现，除非 frets 数据有问题）
     */
    public int getLeastFret() {
        int leastFret = -1;
        for (int i = 0; i < frets.length; i++) {
            int fret = frets[i];
            // 不处理小于 1 品的情况
            if (fret < 1) {
                continue;
            }
            // 第一次为 leastFret 赋值
            if (leastFret == -1) {
                leastFret = fret;
                continue;
            }
            // 对后面的数依次进行比较，得到最小的品
            if (fret < leastFret) {
                leastFret = fret;
            }
        }
        return leastFret;
    }

    /**
     * 获取最大的弦数。
     *
     * @return 最大弦数。
     */
    public int getMaxString() {
        return MAX_STRING;
    }

    @Override
    public String toString() {
        return "Chord{" +
                "frets=" + Arrays.toString(frets) +
                ", fingers=" + Arrays.toString(fingers) +
                '}';
    }
}
