package com.txb.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Leetcode_350 {

    //给定两个数组，编写一个函数来计算它们的交集。
    //输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
    //我们可以不考虑输出结果的顺序。
    public static int[] intersection(int[] nums1, int[] nums2) {
        //使用Map  保存第一个数组，key是数组中的值，value是出现的次数

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num:nums1) {
        	if(!map.containsKey(num)) {
        		map.put(num,1);
        	}else {
        		map.put(num, map.get(num)+1);
        	}
        }
        	
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums2) {
        	if(map.containsKey(num)) {
        		list.add(num);
        		map.put(num,map.get(num)-1);
        		
        		if(map.get(num)==0) {
        			map.remove(num);
        		}
        	}
        }
        	
  
        //把集合转为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int []ad = intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(ad);
    }

}
