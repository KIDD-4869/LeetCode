package com.kxqin.leetcode


/**
 * @author KIDD
 * @description 两数之和
 * @date 2021/4/27
 */
class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i
                    result[1] = j
                    return result
                }
            }
        }
        return result
    }
}