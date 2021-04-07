package com.jcc.java.temp;

import java.util.*;

/**
 * @program: javaknowledge->TestClass
 * @description:
 * @author: jinchuanchuan1@le.com
 * @create: 2021-03-03 17:48
 **/
public class TestClass {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
//        return nums[nums.length / 2];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i] + 1));
            }
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

            entry.getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        HashSet<User> set = new HashSet<>();
//        User zhangsan = new User();
//        zhangsan.setAge(20);
//        set.add(zhangsan);
//        zhangsan.setAge(21);
//        Iterator it = set.iterator();
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }
//        System.out.println(set.contains(zhangsan));
        User u1 = new User("Tom", 10);
        User u2 = new User("Tom", 10);
        User u3 = new User("Tom", 10);
        set.add(u1);
        set.add(u2);
        set.add(u3);
        System.out.println(set.size());
    }
}
