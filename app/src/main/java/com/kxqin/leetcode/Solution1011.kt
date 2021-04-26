package com.kxqin.leetcode


/**
 * @author KIDD
 * @description 在D天内送达包裹的能力
 * @date 2021/4/26
 */
class Solution1011 {
    fun shipWithinDays(weights: IntArray, D: Int): Int {
        //运载能力的最大值为：一天全运走所有货物
        var max = weights.sum()
        //运载能力的最小值为：所有货物中单个最大的重量
        var min = weights.max()?:1
        while (min < max) {
            val mid = (min + max) / 2
            if (checkAbility(weights, D, mid)) {
                //符合当前承载能力，就将值赋给min，因为是逐步增加承载力
                max = mid
            } else {
                //+1的目的是逐步找到最小承载能力
                min = mid + 1
            }
        }
        //当前最小值即符合D要求的最小载运量
        return min
    }

    private fun checkAbility(weights: IntArray, D: Int, ability: Int): Boolean {
        var countDay = 1
        var tempAbility = ability
        for (item in weights) {
            if (tempAbility - item >= 0) {
                //承载能力大于当前货物重量，比较下一组货物
                tempAbility -= item
                continue
            } else {
                countDay++
                if (countDay > D) return false
                //上一组运货中不满足条件，新增一天使用满载运量再装一次
                tempAbility = ability - item
            }
        }
        //走出来即证明次载运量符合D的要求
        return true
    }
}