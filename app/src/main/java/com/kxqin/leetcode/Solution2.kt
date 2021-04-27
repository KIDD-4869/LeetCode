package com.kxqin.leetcode


/**
 * @author KIDD
 * @description 两数之和
 * @date 2021/4/22
 */
class Solution2 {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
        val result = ListNode(0)
        var temp1: ListNode? = l1
        var temp2: ListNode? = l2
        var tempResult: ListNode? = result
        //进位
        var carry = 0
        //不为空或者有进位
        while (temp1 != null || temp2 != null || carry != 0) {
            val temp1Value = temp1?.`val`?:0
            val temp2Value = temp2?.`val`?:0
            //当前相加结果
            val sum = temp1Value + temp2Value + carry
            //新的进位
            carry = sum / 10
            val newNode = ListNode(sum % 10)
            tempResult?.next = newNode
            //重新设置temp节点，进行下一轮计算
            tempResult = newNode
            temp1 = temp1?.next
            temp2 = temp2?.next
        }
        //返回初始节点的next即是结果的根节点
        return result.next!!
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

}

