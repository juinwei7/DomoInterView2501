package com.weiwei;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class LeeCode {

        public static void main(String[] args) {
            String s = "()()()()(())(()())";
            int result = CheckValid(s);
            if (result == -1) {
                System.out.println("NO!");
            } else {
                System.out.println("Yes! Count:" + result);
            }

        }

        private static String Stream(List<String> s) {
            return (String)s.stream().map((st) -> {
                return "TEST-" + st;
            }).collect(Collectors.joining(","));
        }

        public static int CheckValid(String s) {
            int total = 0;
            Stack<Character> stack = new Stack();
            char[] var3 = s.toCharArray();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                char c = var3[var5];
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.empty()) {
                        return -1;
                    }

                    char crr = (Character)stack.pop();
                    if (crr == '(' && c != ')') {
                        return -1;
                    }
                }

                ++total;
            }

            if (!stack.empty()) {
                return -1;
            } else {
                return total / 2;
            }
        }

}
