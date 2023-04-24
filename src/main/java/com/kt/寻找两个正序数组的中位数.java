package com.kt;

import java.util.Arrays;

public class 寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double middle = findMedianSortedArrays(nums1, nums2);
        System.out.println("中位数=" + middle);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int[] nums = new int[num1Length + num2Length];
        for (int i = 0; i < num1Length; i++) {
            nums[i] = nums1[i];
        }
        int start = num1Length;
        for (int i = 0; i < num2Length; i++) {
            nums[start++] = nums2[i];
        }

        Arrays.sort(nums);

        if (nums.length % 2 == 0) {
            int idx1 = nums.length / 2 - 1;
            int num = nums[idx1];
            int idx2 = idx1 + 1;
            int num1 = nums[idx2];
            return (double)(num + num1) / 2;
        }
        int idx1 = nums.length / 2;
        return nums[idx1];
    }

}
