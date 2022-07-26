package com.jcc.algorichms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC93 {
    public List<String> restoreIpAddresses(String s) {
        dfs(s,0,new ArrayList<>());
        return res;
    }
    private List<String> res = new ArrayList<>();
    private int selected=0;//选定了多少数字
    private void dfs(String s, int begin, List<String> path){
        //若余下的字符串长度不合法
        if(s.length()-selected > 3*(4-path.size()) || s.length()-selected < 4-path.size())
            return;
        if(path.size()==4){
            if(selected!=s.length())
                return;
            StringBuilder sb=new StringBuilder(path.get(0));
            for(int i=1;i<path.size();i++){
                sb.append(".");
                sb.append(path.get(i));
            }
            res.add(sb.toString());
            return;
        }
        for(int len = 1;len < 4 && begin+len <= s.length(); len++){
            String subs = s.substring(begin,begin+len);
            if(judge(subs)){
                path.add(subs);
                selected += subs.length();
                dfs(s,len+begin,path);
                path.remove(path.size()-1);
                selected -= subs.length();
            }
        }
    }
    private boolean judge(String s){
        if(s.charAt(0) == '0'){//前导0
            if(s.length()>1)
                return false;
        }
        int num=0;
        for(int i = 0;i < s.length(); i++){
            num *= 10;
            num += s.charAt(i)-'0';
        }
        return num>=0 && num<=255;
    }
}
