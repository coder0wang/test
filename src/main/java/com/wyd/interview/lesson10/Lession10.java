package com.wyd.interview.lesson10;


public class Lession10 {
		public static void main(String[] args) {
			Dijkstra test=new Dijkstra();
			Node start=test.init();
			test.computePath(start);
			test.printPathInfo();
		}
}
