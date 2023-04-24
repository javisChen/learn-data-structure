package com.kt.leetcode;

import java.util.HashMap;

public class 无重复字符的最长子串 {

    public static void main(String[] args) {
//        String string = "pwwkew";
//        String string = "abcdafghemnca";
        String string = "abbacb";
//        String string = "abcabcbb";
//        String string = "pwwkew";
        System.out.println("最大字串长度：" + lengthOfLongestSubstring1(string));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int length = s.length();
        if (length == 1) {
            return 1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    // cdd
    public static int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s.isEmpty()) {
            return 0;
        }
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        int max = 0;    //用于记录最大不重复子串的长度
        int left = 0;   //滑动窗口左指针
        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            if (map.containsKey(charAt)) {
                System.out.println("重复字符子串：" + s.substring(left, i));
                // 比如abbacb，第一次a的下标是0，如果第二次又找到a，left又变回0就有问题了，所以用Max来取最大值。
                left = Math.max(left, map.get(s.charAt(i)) + 1);
//                left = map.get(s.charAt(i)) + 1;
            }
            map.put(charAt, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
