/*
 * Copyright 2018 Airsaid. https://github.com/airsaid
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.airsaid.library.widget;

import java.util.Arrays;

/**
 * 和铉。根据规则，当品数据为 -1 时表示闭弦，为 0 时表示空弦。
 *
 * @author airsaid
 */
public class Chord {

    /** 弦数 */
    public static final int STRING = 6;

    /** 品 */
    private int[] frets;
    /** 指法 */
    private int[] fingers;

    public Chord() {}

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
     * 获取和弦中最大的品。
     *
     * @return 最大品，当没有找到时会返回 -1。（这种情况一般不会出现，除非 frets 数据有问题）
     */
    public int getLargestFret() {
        int largest = -1;
        for (int i = 0; i < frets.length; i++) {
            int fret = frets[i];
            // 不处理小于 1 品的情况
            if (fret < 1) {
                continue;
            }
            // 第一次为 largest 赋值
            if (largest == -1) {
                largest = fret;
                continue;
            }
            // 对后面的数依次进行比较，得到最大的品
            if (fret > largest) {
                largest = fret;
            }
        }
        return largest;
    }

    /**
     * 通过指定的弦获取对应位置的品。
     *
     * @param string 弦
     * @return 品。
     */
    public int getFret(int string) {
        return frets[string - STRING];
    }

    @Override
    public String toString() {
        return "Chord{" +
                "frets=" + Arrays.toString(frets) +
                ", fingers=" + Arrays.toString(fingers) +
                '}';
    }
}
