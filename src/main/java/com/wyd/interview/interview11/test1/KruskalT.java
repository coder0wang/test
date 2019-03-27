package com.wyd.interview.interview11.test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class KruskalT {
	private Set<String> points=new HashSet<String>();
	private List<Edge> treeEdges=new ArrayList<Edge>();
	public void buildTree(){
		MapBuilder builder=new MapBuilder();
		TreeSet<Edge> edges=builder.build();
		int pointNum=builder.getPointNum();
		for(Edge edge:edges){
			if(isCircle(edge)){
				continue;
			}else{//没有出现回路,将这条边加入treeEdges集合
				treeEdges.add(edge);
				//如果边数等于定点数-1,则遍历结束
				if(treeEdges.size()==pointNum-1){
					return;
				}
			}
		}
	}
	public void printTreeInfo(){
		int totalDistance=0;
		for(Edge edge:treeEdges){
			totalDistance+=edge.getDistance();
			System.out.println(edge.toString());
		}
		System.out.println("总路径长度:"+totalDistance);
	}
	private boolean isCircle(Edge edge){
		int size=points.size();
		if(!points.contains(edge.getStart())){
			size++;
		}
		if(!points.contains(edge.getEnd())){
			size++;
		}
		if(size==treeEdges.size()+1){
			return true;
		}else{
			points.add(edge.getStart());
			points.add(edge.getEnd());
			return false;
		}
	}
}