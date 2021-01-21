package com.jcc.algorichms.wanzhuanLiuyubo.oldtemp;

/**
 * @program: javaknowledge->LeetCode125
 * @description: 回文问题
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-07 18:24
 **/
public class LeetCode125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
