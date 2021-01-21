package com.jcc.algorichms.wanzhuanLiuyubo.ch06_Stack_and_Queue.A01_Valid_Parentheses;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * @program: javaknowledge->Leetcode20
 * @description: 有效括号
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-18 21:31
 **/
public class Leetcode20 {
    public boolean isValid(String s) {
        if(StringUtils.isBlank(s)) {
            return true;
        }
        Stack<Character> stack =  new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character match = null;
                Character des = stack.pop();
                if (s.charAt(i) == '}') {
                    match = '{';
                } else if (s.charAt(i) == ']') {
                    match = '[';
                } else {
                    assert (s.charAt(i) != ')');
                    match = '(';
                }
                if (des.equals(match)) {
                    return true;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
