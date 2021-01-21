package com.jcc.algorichms.wanzhuanLiuyubo.ch06_Stack_and_Queue.A01_Valid_Parentheses;

import java.util.Stack;

/**
 * @program: javaknowledge->Leetcode71
 * @description: simplify path
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-18 23:29
 **/
public class Leetcode71 {
    public static String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : pathArray) {
            switch (s) {
            case "/" :
                break;
            case "." :
                break;
            case "" :
                break;
            case ".." :
                stack.pop();
                break;
            default:
                stack.push(s);
                break;
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }
}
