package com.wyd.algorithm.lesson4;


/**
 * 

* @Title: TestTree.java 

* @Package com.wyd.algorithm.lesson4 

* @Description: TODO(用一句话描述该文件做什么) 

* @author Coder 

* @date 2016-7-4 上午1:34:38 

* @version V1.0
 */
public class TestTree {
	/**
	 * 小的计算
	 * @param node
	 * @return
	 */
	public Node minimum(Node node){
		while (node.getLeft()!= null){
			node = node.getLeft();
			}
		return node;
	}
	/**
	 * 大的计算
	 * @param node
	 * @return
	 */
	public Node maximum(Node node){
		while (node.getRigth()!= null){
			node = node.getRigth();
			}
		return node;
	}
	/**
	 * SUCCESSOR 计算
	 */
	public Node SUCCESSOR(Node node){
		Node tempNode = new Node();
		if (node.getRigth()!=null) {
			return minimum(node.getRigth());
		}
		tempNode = node.getParent();
		while(tempNode!=null && node == tempNode.getRigth()){
			node = tempNode;
			tempNode = tempNode.getParent();
		}
		
		return node;
	}
	
}
