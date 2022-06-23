package com.ruimin.ifs.ifincar.ocr.service.impl;

import com.ruimin.ifs.business.common.GlobalInfo;
import com.ruimin.ifs.framework.exceptions.CommonException;
import com.ruimin.ifs.ifincar.standardiface.util.ThreadPool;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: LeetCode Demo
 * @Author: Jin ran
 * @Date: 2022/6/20 15:32
 */
public class DemoTest {

    /**
     * @Description: 两数之和
     * @Author: Jin ran
     * @Date: 2022/6/20 15:34
     */
    @Test
    public void leetCodeOne() {
        int target = 10;
        int[] nums = {5, 5, 5, 10};
        int[] indexs = new int[2];
        // 建立k-v ，一一对应的哈希表 题库中的
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = hash.get(nums[i]);
                indexs[1] = i;
            }
            //这里用map的key 来去重了
            hash.put(target - nums[i], i);
        }
        //两数之和 自己写的
        //List list = new ArrayList<>();
        //for (int i = 0; i < nums.length; i++) {
        //    int a = target - nums[i];
        //    list.add(nums[i]);
        //    int b = list.indexOf(a);
        //    if (b >= 0  && b!=i) {
        //        indexs[0] = b;
        //        indexs[1] = i;
        //
        //    }
        //}
        for (int index : indexs) {
            System.out.println(index);
        }
        System.out.println(hash);
    }

    /**
     * @Description: 无重复字符的最长子串 使用滑动窗口解决
     * @Author: Jin ran
     * @Date: 2022/6/21 11:03
     */
    @Test
    public void leetCodeThree() {
        String input = "pwwkew";
        char[] chars = input.toCharArray();
        StringBuffer str = new StringBuffer();
        HashMap<String, Integer> map = new HashMap<>(16);
        List list = new ArrayList<>();
        //循环遍历 子串的尾部如果和遍历的元素相等,那字符串的第一个元素移除
        for (int i = 0; i < chars.length; i++) {
            if (str.toString().endsWith(String.valueOf(chars[i]))) {
                continue;
            }
            map.put(String.valueOf(chars[i]), i);
            list.add(chars[i]);
        }
        System.out.println(map.keySet());
    }

    @Test
    public void threadDemo() {
        int finalI = 0;
        while (finalI > 10) {
            ThreadPool.getThreadPoolExecutor().execute(() -> {
                System.out.println("当前线程名字" + Thread.currentThread() + finalI);
                //finalI++;
            });
        }
    }
}
