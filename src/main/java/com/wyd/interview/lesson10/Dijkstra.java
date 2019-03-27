package com.wyd.interview.lesson10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
	Set<Node> open=new HashSet<Node>();
	Set<Node> close=new HashSet<Node>();
	Map<String,Integer> path=new HashMap<String,Integer>();//封装路径距离
	Map<String,String> pathInfo=new HashMap<String,String>();//封装路径信息
	public Node init(){
		//初始路径,因没有路径,所以path设置为Integer.MAX_VALUE
		path.put("1", 1);
		pathInfo.put("1", "0->1");
		path.put("2", 4);
		pathInfo.put("2", "0->2");
		path.put("3", Integer.MAX_VALUE);
		pathInfo.put("3", "0");
		path.put("3", Integer.MAX_VALUE);
		pathInfo.put("4", "0");
		path.put("4", Integer.MAX_VALUE);
		pathInfo.put("5", "0");
		path.put("5", Integer.MAX_VALUE);
		//将初始节点放入close,其他节点放入open
		Node start=new MapBuilder().build(open,close);
		return start;
	}
	public void computePath(Node start){
		Node nearest=getShortestPath(start);//取距离start节点最近的子节点,放入close
		if(nearest==null){
			return;
		}
		close.add(nearest);
		open.remove(nearest);
		Map<Node,Integer> childs=nearest.getChild();
		for(Node child:childs.keySet()){
			if(open.contains(child)){//如果子节点在open中
				Integer newCompute=path.get(nearest.getName())+childs.get(child);
				if(path.get(child.getName())>newCompute){//之前设置的距离大于新计算出来的距离
					path.put(child.getName(), newCompute);
					pathInfo.put(child.getName(), pathInfo.get(nearest.getName())+"->"+child.getName());
				}
			}
		}
		computePath(start);//重复执行自己,确保所有子节点被遍历
		computePath(nearest);//向外一层层递归,直至所有顶点被遍历
	}
	public void printPathInfo(){
		Set<Map.Entry<String, String>> pathInfos=pathInfo.entrySet();
		for(Map.Entry<String, String> pathInfo:pathInfos){
			System.out.println(pathInfo.getKey()+":"+pathInfo.getValue());
		}
	}
	/**
	 * 获取与node最近的子节点
	 */
	private Node getShortestPath(Node node){
		Node res=null;
		int minDis=Integer.MAX_VALUE;
		Map<Node,Integer> childs=node.getChild();
		for(Node child:childs.keySet()){
			if(open.contains(child)){
				int distance=childs.get(child);
				if(distance<minDis){
					minDis=distance;
					res=child;
				}
			}
		}
		return res;
	}
}
