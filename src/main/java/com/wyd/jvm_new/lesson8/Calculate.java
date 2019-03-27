//package com.wyd.jvm_new.lesson8;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import org.netbeans.lib.profiler.heap.HeapFactory;
//import org.netbeans.modules.profiler.oql.engine.api.OQLEngine;
//import org.netbeans.modules.profiler.oql.engine.api.OQLEngine.ObjectVisitor;
//
//public class Calculate {
//	public static void main(String[] args) throws Exception {
//		final List<Long> listTimes = new ArrayList<Long>(10000);
//		List<Integer> listOccurs = new ArrayList<Integer>(10000);
//		String query = "select s.creationTime from org.apache.catalina.session.StandardSession s";
//		OQLEngine instance = new OQLEngine(HeapFactory.createHeap(new File(
//				"G:\\课程\\jvm_new\\8\\tomcat_第8周第2题\\tomcat.hprof")));
//
//		ObjectVisitor visitor = new ObjectVisitor() {
//			public boolean visit(Object o) {
//				listTimes.add(new Long(o.toString()));
//				return false;
//			}
//		};
//
//		instance.executeQuery(query, visitor);
//
//		Collections.sort(listTimes);
//		int distance;
//		for (int i = 0; i < listTimes.size(); i++) {
//			distance = 0;
//			for (int j = i + 1; j < listTimes.size(); j++) {
//				distance = j - i;
//				if (listTimes.get(j) - listTimes.get(i) > 1000) {  
//					break;
//				}
//			}
//			listOccurs.add(new Integer(distance));
//		}
//
//		int maxDistance = 0;
//		int maxIndex = 0;
//		for (int i = 0; i < listOccurs.size(); i++) {
//			if (listOccurs.get(i) > maxDistance) {
//				maxDistance = listOccurs.get(i);
//				maxIndex = i;
//			}
//		}
//
//		System.out.println("时间范围为 [" + listTimes.get(maxIndex)
//				+ "] 到 [" + (listTimes.get(maxIndex))
//				+ "], 最大请求 是 第"+maxIndex+" 次 为"+ listOccurs.get(maxIndex) + ".");
//	}
//}
