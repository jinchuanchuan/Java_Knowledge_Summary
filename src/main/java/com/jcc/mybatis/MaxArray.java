package com.jcc.mybatis;

public class MaxArray {


    /**
     * 如何理解动态规划状态转移方程？
     * 不妨把状态转移方程理解为递归关系。就是如何从已知求得未知的表达式。
     * 比如找一列数中最大的一个数，如果你知道了前n个数中最大，记做Max_n那么当你遇到第n+1个数x_n+1的时候，前n+1个数中最大值是什么呢，就是拿这个新x去和之前那个max比，然后留下较大的一个，对吧，写下来就是
     * Max_n+1 = (x_n+1 > Max_n) ? x_n+1 : Max_n
     * 这就是一个状态转移方程，就是一个递归关系。
     * 不要被术语困住，语言都是苍白的。
     *
     * 作者：floatingH2O
     * 链接：https://www.zhihu.com/question/28619606/answer/107400815
     * 来源：知乎
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 评论：
     * 和递归的区别就是保留上一次的结果, 线性的比大小不太好区分, 用斐波那契数列理解一下就更明白了
     *
     * */

    public static void main(String[] args) {
        int[] nums = {2,4,5,6,1,0,9,7};
        System.out.println(maxSubArray(nums));
    }

    public static Integer maxSubArray(int[] nums) {
        Integer pre = 0, maxAns = nums[0];
        for(int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
}
