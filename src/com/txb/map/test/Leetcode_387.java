package com.txb.map.test;

public class Leetcode_387 {

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * 您可以假定该字符串只包含小写字母。
     */
    class Solution {

        /**
         * 可以定义一个数组，长度是26，坐标分别用来代表字母a～z，值就是频率
         * 然后再遍历整个数组，找到第一个值为1的，返回这个index
         */
        public int firstUniqChar(String s) {
            int[] frep = new int[26];
            for (int i = 0; i < s.length(); i++) {
                frep[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (frep[(s.charAt(i) - 'a')] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

}
