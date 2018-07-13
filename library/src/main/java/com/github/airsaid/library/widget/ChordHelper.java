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

/**
 * @author airsaid
 */
public class ChordHelper {

    /**
     * 获取横按和弦所需要的信息。分别是品、和截止弦。
     *
     * @param chord 和弦对象
     * @return 信息数组，当是横按情况时，角标 0 处存储的是品，角标 1 处存储的是截止弦。当非横按时返回 NULL。
     */
    public int[] getBarreChordData(Chord chord) {
        int[] data = new int[2];

        // 判断是否有空弦
        boolean emptyString = chord.isEmptyString();
        if (emptyString) {
            int withFirstString = getWithFirstString(chord);
            // 判断 1 弦处是否是和弦中最小的品，并且更高的弦与 1 弦品相同且相连
            if (firstStringLeast(chord) && withFirstString > 1) {
                // 横按：1 弦 -> 相连的最高弦
                data[0] = chord.getLeastFret();
                data[1] = withFirstString;
            } else {
                // 非横按
                return null;
            }
        } else {
            // 判断是否有闭弦
            if (chord.isClosedString()) {
                // 横按：1 弦 -> 最高弦（如果最高弦处是闭弦，则再倒退一弦，直到非闭弦处）
                data[0] = chord.getLeastFret();
                data[1] = getMaxUnClosedString(chord);
            } else {
                // 横按：1 弦 -> 吉他的最高弦
                data[0] = chord.getLeastFret();
                data[1] = chord.getMaxString();
            }
        }

        return data;
    }

    /**
     * 获取 1 弦处的品是否是整个和弦中最小的品。
     *
     * @param chord 和弦对象
     * @return 1 弦处是最小的品则返回 true，否则返回 false。
     */
    public boolean firstStringLeast(Chord chord) {
        int[] frets = chord.getFrets();
        return frets[frets.length - 1] == chord.getLeastFret();
    }

    /**
     * 获取同 1 弦处相同品的最大弦。
     *
     * 比如和弦为：3,3,2,1,1,1 那么第 1 弦的品为 1，而 2、3 弦也和 1 弦品相同，于是返回最大的弦： 3（弦）。
     *
     * @param chord 和弦对象
     * @return 最大弦。
     */
    public int getWithFirstString(Chord chord) {
        int string = 1;
        int[] frets = chord.getFrets();
        while (frets[frets.length - 1] == frets[frets.length - 1 - string]) {
            string += 1;
        }
        return string;
    }

    /**
     * 获取最大的非闭弦的弦。
     *
     * 假设和弦为：-1,3,2,1,1,1 那么最大的弦本来是第 6 弦，但是第 6 弦处是个空弦，那么就看第 5 弦，由于不是闭弦，于是返回 5。
     *
     * @param chord 和弦对象
     * @return 弦。
     */
    public int getMaxUnClosedString(Chord chord) {
        int[] frets = chord.getFrets();
        int string = frets.length;
        while (frets[frets.length - string] == -1) {
            string -= 1;
        }
        return string;
    }

}
