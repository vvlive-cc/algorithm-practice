package com.wyd.algorithm._03hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wyd
 * @Description: 有效的字母异位词
 * @Date: 2025/3/13
 */
public class _0242_isAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap1.containsKey(s.charAt(i))) {
                hashMap1.put(s.charAt(i), hashMap1.get(s.charAt(i)) + 1);
            } else {
                hashMap1.put(s.charAt(i), 1);
            }
        }

        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (hashMap2.containsKey(t.charAt(i))) {
                hashMap2.put(t.charAt(i), hashMap2.get(t.charAt(i)) + 1);
            } else {
                hashMap2.put(t.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : hashMap2.entrySet()) {
            if (!hashMap1.containsKey(entry.getKey())) {
                return false;
            }

            if (!entry.getValue().equals(hashMap1.get(entry.getKey()))) {
                return false;
            }
        }

        return true;
    }
}
