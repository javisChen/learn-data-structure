package com.kt.leetcode;

import java.util.Hashtable;
import java.util.Map;

public class 两数相加 {

    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int target = 10;
        int[] ints = twoSum2(nums, target);
        System.out.print("result：");
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * 暴力解法
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 利用map
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
