package org.example;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    //
    //示例 1：
    //输入：nums = [1,1,2]
    //输出：
    //[[1,1,2],
    // [1,2,1],
    // [2,1,1]]
    //
    //示例 2：
    //输入：nums = [1,2,3]
    //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    //
    //
    //提示：
    //1 <= nums.length <= 8
    //-10 <= nums[i] <= 10
    // 【1】 【2， 3】 【3，2】
    public static void main(String[] args) {
        int[] numbers = new int[] {1,2,3};
        Solution a = new Solution();
        System.out.println(a.permuteUnique(numbers));
    }
}
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        if(nums.length == 1) {
            List<Integer> return0 = new ArrayList<>();
            return0.add(nums[0]);
            returnList.add(return0);
            return returnList;
        }
        if(nums.length == 2) {
            // 处理len=2
            List<Integer> return1 = new ArrayList<>();
            return1.add(nums[0]);
            return1.add(nums[1]);
            returnList.add(return1);
            List<Integer> return2 = new ArrayList<>();
            return2.add(nums[1]);
            return2.add(nums[0]);
            returnList.add(return2);
            return returnList;
        }
        for (int j = 0; j < nums.length - 2; j++) {
            int x = nums[j];
            int[] newNums = new int[nums.length - 1];
            for (int i = 1; i < nums.length; i++) {
                newNums[i - 1] = nums[i];
            }
            List<List<Integer>> ret = permuteUnique(newNums);
            for (int k = 0; k < ret.size(); k++) {
                ret.get(k).add(0, Integer.bitCount(x));
            }
            returnList.addAll(ret);
        }
        return returnList;
    }
}