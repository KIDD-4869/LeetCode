package com.kxqin.leetcode


/**
 * @author KIDD
 * @description 二叉搜索树的范围和
 * @date 2021/4/27
 */
class Solution938 {
    /**
     * 这没看题解，还真没看懂题目要求的啥。。。
     * 课代表：求出low-high之间所有值的和
     */
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) {
            return 0
        }
        if (root.`val` < low) {
            //如果当前节点的左节点小于最小值，那说明左子树都是小于的，直接看右子树
            return rangeSumBST(root.right, low, high)
        }
        if (root.`val` > high) {
            //如果当前节点的右节点大于最大值，说明右子树都是大于区间，直接看左子树
            return rangeSumBST(root.left, low, high)
        }
        //如果以上条件不符合，即当前节点值在区间之间，那么左子树和右子树都需要再计算。
        return root.`val` + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}