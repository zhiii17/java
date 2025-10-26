/**
 * 1. 两数之和
 * 难度：简单
 * 
 * 题目描述：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 
 * 解题思路：
 * 方法1：暴力枚举 - 两层循环遍历所有组合
 * 方法2：哈希表 - 用空间换时间，查找时间降到O(1)
 * 
 * 执行结果：
 * 暴力法：时间复杂度 O(n²)，空间复杂度 O(1)
 * 哈希表：时间复杂度 O(n)，空间复杂度 O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class Solution_001_TwoSum {
    /**
     * 方法一：暴力解法
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    
    /**
     * 方法二：哈希表优化
     */
    public int[] twoSumHashmap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
    
    /**
     * 测试方法
     */
    public static void main(String[] args) {
        Solution_001_TwoSum solution = new Solution_001_TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        // 测试暴力解法
        int[] result1 = solution.twoSumBruteForce(nums, target);
        System.out.println("暴力解法结果: [" + result1[0] + ", " + result1[1] + "]");
        
        // 测试哈希表解法
        int[] result2 = solution.twoSumHashmap(nums, target);
        System.out.println("哈希表结果: [" + result2[0] + ", " + result2[1] + "]");
    }
}
