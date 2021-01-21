package com.jcc.algorichms.leetcode_swordfingeroffer;

/**
 * @program: javaknowledge->offer05
 * @description: 替换空格
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-16 19:57
 **/
public class offer05 {
    public String replaceSpace(String s) {
//        s.replace(" ", "%20");
        if (s == null) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                str.append("%20");
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}
