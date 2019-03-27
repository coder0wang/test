package com.wyd.algorithm.lesson5;

import javax.tools.JavaCompiler;

/**
 * 

* @Title: Node.java 

* @Package com.wyd.algorithm.lesson4 

* @Description: TODO(用一句话描述该文件做什么) 

* @author Coder 

* @date 2016-7-4 上午1:33:08 

* @version V1.0
 */
public class BTreeNode implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6571985205362576954L;
	private int self;
	private BTreeNode left;
	private BTreeNode rigth;
	private BTreeNode parent;
	public int getSelf() {
		return self;
	}
	public void setSelf(int self) {
		this.self = self;
	}
	public BTreeNode getLeft() {
		return left;
	}
	public void setLeft(BTreeNode left) {
		this.left = left;
	}
	public BTreeNode getRigth() {
		return rigth;
	}
	public void setRigth(BTreeNode rigth) {
		this.rigth = rigth;
	}
	public BTreeNode getParent() {
		return parent;
	}
	public void setParent(BTreeNode parent) {
		this.parent = parent;
	}

}
