package com.wyd.algorithm.lesson6;

import com.wyd.algorithm.lesson5.BTreeNode;
/**
 * 

* @Title: Solution.java 

* @Package com.wyd.algorithm.lesson6 

* @Description: TODO(用一句话描述该文件做什么) 

* @author Coder 

* @date 2016-7-17 下午11:22:09 

* @version V1.0
 */
public class Solution {
	public boolean isSymmetric(BTreeNode root) {
		// 总体上分为两种情况，一种是空树，一种不是空树
		// case1 树为空
		if (root == null)
			return true;
		// case2 树不为空时要利用递归的方法
		return isSymmetric(root.getLeft(), root.getRigth());
	}

	public boolean isSymmetric(BTreeNode left, BTreeNode right) {
		// case1 树的左右子树为空
		if (left == null && right == null)
			return true;
		// case2 树的左右子树有一个为空
		if (left == null || right == null)
			return false;
		// case3 树的左右子树均不为空，判断节点的值是否相等
		return left.getSelf() == right.getSelf()
				&& isSymmetric(left.getLeft(), right.getRigth())
				&& isSymmetric(left.getRigth(), right.getLeft());
	}
}