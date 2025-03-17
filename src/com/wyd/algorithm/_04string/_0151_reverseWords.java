package com.wyd.algorithm._04string;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author: wyd
 * @Description: 反转字符串中的单词
 * @Date: 2025/3/17
 */
public class _0151_reverseWords {
    public static void main(String[] args) {
        String s = " 3c      2zPeO dpIMVv2SG    1AM       o       VnUhxK a5YKNyuG     x9    EQ  ruJO       0Dtb8qG91w 1rT3zH F0m n G wU";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] splitStr = s.split(" ");
        int left = 0, right = splitStr.length - 1;

        while (left < right) {
            while ("".equals(splitStr[left])) {
                left++;
            }
            while ("".equals(splitStr[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            String temp = splitStr[left];
            splitStr[left] = splitStr[right];
            splitStr[right] = temp;
            left++;
            right--;
        }
        return Arrays.stream(splitStr).filter(str -> !"".equals(str)).collect(Collectors.joining(" "));
    }
}
