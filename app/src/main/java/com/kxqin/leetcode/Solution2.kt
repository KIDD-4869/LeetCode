package com.kxqin.leetcode

import android.util.Log
import java.lang.StringBuilder
import java.util.*


/**
 * @author KIDD
 * @description 两数之和
 * @date 2021/4/22
 */
class Solution2 {

    private val stack1 = Stack<Int>()
    private val stack2 = Stack<Int>()
    private val resultNode = ListNode(0)

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
        getNumber(l1, stack1)
        getNumber(l2, stack2)
        val num1 = caculatNum(stack1)
        val num2 = caculatNum(stack2)
        val result = num1 + num2
        getStack(result)
        return resultNode
    }

    /**
     * 将节点转化为栈存储
     */
    private fun getNumber(node: ListNode?, stack: Stack<Int>) {
        if (node != null) {
            stack.add(node.value)
            if (node.next != null) {
                getNumber(node.next, stack)
            }
        }
    }

    /**
     * 将栈里数据取出来
     */
    private fun caculatNum(stack: Stack<Int>): Int {
        val stringBuilder = StringBuilder()
        for (item in stack) {
            stringBuilder.append("$item")
        }
        return stringBuilder.toString().toInt()

    }

    /**
     * 将计算结果用栈存储
     */
    private fun getStack(num: Int) {
        val string = "$num"
        val array = string.toCharArray().toList()
        val stack3 = Stack<Int>()
        for (item in array) {
            stack3.add(item.toInt())
        }
        getListNode(stack3, resultNode)
    }

    private fun getListNode(stack: Stack<Int>, listNode: ListNode) {
        if (stack.isNotEmpty()) {
            listNode.value = stack.pop()
            if (stack.isNotEmpty()) {
                listNode.next = ListNode(0)
                getListNode(stack, listNode.next!!)
            }
        }

    }

    class ListNode(var value: Int) {
        var next: ListNode? = null
    }
}

fun main() {
    val listNode1 = Solution2.ListNode(2)
    val listNode2 = Solution2.ListNode(1)
    listNode1.next = listNode2
    val listnode3 = Solution2().addTwoNumbers(listNode1, listNode1)
    Log.d("KIDD", listnode3.toString())
}