package com.kxqin.leetcode


/**
 * @author KIDD
 * @description 无重复字符的最长子串
 * @date 2021/4/27
 */
class Solution3 {
    /**
     * 这种方法比较直观，就字面意思计算最大长度，但是效率不如滑动窗口
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val stringBuilder = StringBuilder()
        var result = 0
        var count = 0
        for (item in s) {
            if (!stringBuilder.contains(item)) {
                stringBuilder.append(item)
                count++
            } else {
                if (count > result) {
                    result = count
                }
                //计算此次重复item之前的位置
                val p = stringBuilder.indexOf(item)
                if (p != stringBuilder.length - 1) {
                    stringBuilder.append(item)
                    val string = stringBuilder.substring(p + 1, stringBuilder.length)
                    stringBuilder.clear()
                    stringBuilder.append(string)
                    count = string.length
                } else {
                    //最后一位重复，清空重新计算。
                    stringBuilder.clear()
                    stringBuilder.append(item)
                    count = 1
                }
            }
        }
        //这里如果是一直加到最后没有赋值的话，进行赋值
        if (count > result) {
            result = count
        }
        return result
    }
}
