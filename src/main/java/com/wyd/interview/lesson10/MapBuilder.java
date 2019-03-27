package com.wyd.interview.lesson10;

import java.util.Set;

public class MapBuilder {
	public Node build(Set<Node> open, Set<Node> close){
		Node node0=new Node("0");
		Node node1=new Node("1");
		Node node2=new Node("2");
		Node node3=new Node("3");
		Node node4=new Node("4");
		Node node5=new Node("5");
		node0.getChild().put(node1, 1);
		node0.getChild().put(node2, 4);
		
		node1.getChild().put(node0, 1);
		node1.getChild().put(node2, 1);
		node1.getChild().put(node3, 5);
		
		node2.getChild().put(node0, 4);
		node2.getChild().put(node1, 1);
		node2.getChild().put(node3, 2);
		node2.getChild().put(node4, 3);
		
		node3.getChild().put(node1, 5);
		node3.getChild().put(node2, 2);
		node3.getChild().put(node5, 6);
		
		node4.getChild().put(node2, 3);
		node4.getChild().put(node5, 2);
		
		node5.getChild().put(node3, 6);
		node5.getChild().put(node4, 2);
		
		open.add(node1);
		open.add(node2);
		open.add(node3);
		open.add(node4);
		open.add(node5);
		close.add(node0);
		return node0;
	}
}