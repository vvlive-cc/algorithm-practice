package com.wyd.algorithm._04string;

/**
 * @Author: wyd
 * @Description: 反转字符串2
 * @Date: 2025/3/17
 */
public class _0541_reverseStr {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
    public static String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i += 2 * k) {
            int left = i, right = Math.min(i + k - 1, charArray.length - 1);

            while (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        return new String(charArray);
    }
}
