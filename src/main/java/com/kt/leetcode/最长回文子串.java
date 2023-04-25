package com.kt.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 最长回文子串 {

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(3);
        integers.add(2);
        integers.add(1);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
//        String s = "a";
//        String s = "cbbd";
//        String s = "babadb";
//        String s = "aacabdkacaa";
        String s = "xaabacxcabaaxcabaax";
//        String s = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
        System.out.println("最长回文子串：" + longestPalindromeV2(s));
    }


    public static String longestPalindromeV1(String s) {
        int length = s.length();
        if (s.isEmpty()) {
            return "";
        }
        if (length == 1) {
            return s;
        }
        String maxText = String.valueOf(s.charAt(0));
        // 存储字符出现过的所有下标，例如：aacabdkacaa，a一共出现了4次，分别是0、1、3、7、9、10
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                List<Integer> list = map.get(c);
                for (Integer idx : list) {
                    boolean isPalindrome = true;
                    // 如果字符已出现过，就遍历所有的下标，截取历史下标到当前下标的字符串
                    // 然后从头尾双向比较，直到找出不同的字符就跳出
                    String s1 = s.substring(idx, i + 1);
                    int strLen = s1.length();
                    for (int head = 0, tail = strLen - 1; head < strLen / 2; head++, tail--) {
                        if (s1.charAt(head) != s1.charAt(tail)) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) {
                        // System.out.println("回文子串：" + s1);
                        // 判断当前回文串是否比最长字符串要长，是的话就更新
                        maxText = strLen > maxText.length() ? s1 : maxText;
                    }
                }
                map.get(c).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
        }
        return maxText;
    }

    public static String longestPalindromeV2(String s) {
        int length = s.length();
        if (s.isEmpty()) {
            return "";
        }
        if (length == 1) {
            return s;
        }
        String maxText = String.valueOf(s.charAt(0));
        // 存储字符出现过的所有下标，例如：aacabdkacaa，a一共出现了4次，分别是0、1、3、7、9、10
//        HashMap<Character, List<Integer>> map = new HashMap<>();
        HashMap<Character, List<Integer>> map = new HashMap<>();
        HashMap<Character, Integer> lastTrueMap = new HashMap<>();
        HashMap<Character, Boolean> lastCheckMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                List<Integer> list = map.get(c);
                boolean isPalindrome = true;
                int size = list.size();
                for (int j = size - 1; j >= 0; j--) {
                    // 判断字符是否有进行过回文判断，如果没有就做一次回文判断
                    // 如果有，并且上一次的回文判断不通过的话直接break
                    // 如果最后一次回文通过，那么就判断当前回文
                    if (lastCheckMap.containsKey(c)) {
                        if (!lastCheckMap.get(c)) {
                            break;
                        }
                    }
                    Integer idx = list.get(j);
                    String s1 = s.substring(idx, i + 1);
                    int strLen = s1.length();
                    // 如果字符已出现过，就遍历所有的下标，截取历史下标到当前下标的字符串
                    // 然后从头尾双向比较
                    for (int head = 0, tail = strLen - 1; head < strLen / 2; head++, tail--) {
                        if (s1.charAt(head) != s1.charAt(tail)) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    lastCheckMap.put(c, isPalindrome);
                    if (isPalindrome) {
                        maxText = strLen > maxText.length() ? s1 : maxText;
                    }
                }
                map.get(c).add(i);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(c, list);
            }
        }
        return maxText;
    }
}
