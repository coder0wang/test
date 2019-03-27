package com.wyd.interview.interview11.test1;

import java.util.TreeSet;

public class MapBuilder {
	public TreeSet<Edge> build(){
		TreeSet<Edge> edges=new TreeSet<Edge>();
		edges.add(new Edge("0","1",1));
		edges.add(new Edge("0","2",4));
		edges.add(new Edge("1","0",1));
		edges.add(new Edge("1","2",3));
		edges.add(new Edge("1","3",5));
		edges.add(new Edge("2","0",4));
		edges.add(new Edge("2","1",3));
		edges.add(new Edge("2","3",1));
		edges.add(new Edge("2","4",3));
		edges.add(new Edge("3","1",5));
		edges.add(new Edge("3","2",1));
		edges.add(new Edge("3","5",6));
		edges.add(new Edge("4","2",3));
		edges.add(new Edge("4","5",2));
		edges.add(new Edge("5","3",3));
		edges.add(new Edge("5","4",2));
		return edges;
	}
	public int getPointNum(){
		return 5;
	}
}