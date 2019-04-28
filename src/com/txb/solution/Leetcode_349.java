package com.txb.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Leetcode_349 {

    //给定两个数组，编写一个函数来计算它们的交集。
    //输出结果中的每个元素一定是唯一的。
    //我们可以不考虑输出结果的顺序。
    public static int[] intersection(int[] nums1, int[] nums2) {
        //使用set 保存第一个数组，这样就去重了，
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        //再次使用Set去重
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        //把集合转为数组
        int[] res = new int[result.size()];
        int index = 0;

        for (Integer i : result) {
            System.out.println(index);
            res[index++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});

    }

}
