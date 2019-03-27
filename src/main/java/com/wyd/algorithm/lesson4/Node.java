package com.wyd.algorithm.lesson4;

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
public class Node implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6571985205362576954L;
	private int self;
	private Node left;
	private Node rigth;
	private Node parent;
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public int getSelf() {
		return self;
	}
	public void setSelf(int self) {
		this.self = self;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRigth() {
		return rigth;
	}
	public void setRigth(Node rigth) {
		this.rigth = rigth;
	}

}
