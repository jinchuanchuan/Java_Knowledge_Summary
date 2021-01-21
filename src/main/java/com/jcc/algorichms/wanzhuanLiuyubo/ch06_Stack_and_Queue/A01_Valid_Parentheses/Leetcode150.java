package com.jcc.algorichms.wanzhuanLiuyubo.ch06_Stack_and_Queue.A01_Valid_Parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: javaknowledge->Leetcode150
 * @description: 逆波兰表达式求值
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-18 22:06
 **/
public class Leetcode150 {
    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        int op1 = 0;
        int op2 = 0;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+" :
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case "-" :
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                    break;
                case "*" :
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 * op2);
                    break;
                case "/" :
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                    break;
                default:
                    stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
