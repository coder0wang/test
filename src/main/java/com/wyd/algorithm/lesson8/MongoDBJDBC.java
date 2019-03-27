//package com.wyd.algorithm.lesson8;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.hadoop.classification.InterfaceAudience.Private;
//import org.bson.Document;
//
//import com.mongodb.DBCursor;
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.gridfs.GridFS;
//import com.mongodb.gridfs.GridFSInputFile;
//
//public class MongoDBJDBC {
//	public static void main(String args[]) {
//		db();
//	}
//	
//	
//	/*public static void file() {
//		MongoClient mongoClient = null;
//		try {
//			// 连接到 mongodb 服务
//			mongoClient = new MongoClient("192.168.117.101", 10001);
//			// 连接到数据库
//			MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
//			System.out.println("Connect to database successfully");
////			mongoDatabase.createCollection("test1");
////			System.out.println("集合创建成功");
//			//dept emp
//			MongoCollection<Document> collection = mongoDatabase.getCollection("test1");
//			System.out.println("集合 emp 选择成功");
//			File f = new File("D://study//document//MySQL5.1参考手册.chm");
//			GridFS myFS = new GridFS(collection);             
//			GridFSInputFile inputFile = myFS.createFile(f);
//			inputFile.save();
//
//			DBCursor cursor = myFS.getFileList();
//			while(cursor.hasNext()){
//				System.out.println(cursor.next());
//			}	
//			long endTime = new Date().getTime();
//			System.out.println(endTime - start);
//			System.out.println((endTime - start) / 10000000);
//		} catch (Exception e) {
//			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//		}
//	}*/
//	
//	
//	public static void db() {
//		MongoClient mongoClient = null;
//		try {
//			// 连接到 mongodb 服务
//			mongoClient = new MongoClient("192.168.117.101", 10001);
//			// 连接到数据库
//			MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
//			System.out.println("Connect to database successfully");
////			mongoDatabase.createCollection("test1");
////			System.out.println("集合创建成功");
//			//dept emp
//			MongoCollection<Document> collection = mongoDatabase.getCollection("test1");
//			System.out.println("集合 emp 选择成功");
//			List<Document> documentEmp = getDocumentsEmp();
//			List<Document> documentsEmp = new  ArrayList<Document>(); 
////			for (int i = 0; i < 100; i++) {
//				documentsEmp.addAll(documentEmp);
////			}
//			System.out.println(new Date());
//			collection.insertMany(documentsEmp);  
//	        System.out.println(new Date());
//	        System.out.println("文档插入成功");
//		} catch (Exception e) {
//			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//		}
//	}
//	
//	
//	private static List<Document> getDocumentsDept(){
//		//插入文档  
//        /** 
//        * 1. 创建文档 org.bson.Document 参数为key-value的格式 
//        * 2. 创建文档集合List<Document> 
//        * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
//        * */
//        Document document = new Document
//       ("DEPTNO", 10).
//        append("DNAME", "ACCOUNTING").
//        append("LOC", "NEW YORK");  
//        Document document2 = new Document
//        	       ("DEPTNO", 20).
//        	        append("DNAME", "RESEARCH").
//        	        append("LOC", "DALLAS");  
//        Document document3 = new Document
//        	        ("DEPTNO", 30).
//        	        append("DNAME", "SALES").
//        	        append("LOC", "CHICAGO");  
//        Document document4 = new Document
//        	        ("DEPTNO", 40).
//        	        append("DNAME", "OPERATIONS").
//        	        append("LOC", "BOSTON");   
//        List<Document> documents = new ArrayList<Document>();  
//        documents.add(document);
//        documents.add(document2);
//        documents.add(document3);
//        documents.add(document4);
//        return documents;
//	}
//	private static List<Document> getDocumentsEmp(){
//		//插入文档  
//        /** 
//        * 1. 创建文档 org.bson.Document 参数为key-value的格式 
//        * 2. 创建文档集合List<Document> 
//        * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
//        * */
//        Document document = new Document
//       ("EMPNO", 7369).
//        append("ENAME", "SMITH").
//        append("JOB", "CLERK").  
//        append("MGR", 7902). 
//        append("HIREDATE", "17-12月-80"). 
//        append("SAL", 800).  
////        append("COMM ", "database"). 
//        append("DEPTNO", 20);  
//        Document document2 = new Document
//    	        ("EMPNO", 7499).
//    	         append("ENAME", "ALLEN").
//    	         append("JOB", "SALESMAN").  
//    	         append("MGR", 7698). 
//    	         append("HIREDATE", "20-2月-81"). 
//    	         append("SAL", 1600).  
//    	         append("COMM ", "300"). 
//    	         append("DEPTNO", 30);  
//        Document document3 = new Document
//    	        ("EMPNO", 7369).
//    	         append("ENAME", "WARD").
//    	         append("JOB", "SALESMAN").  
//    	         append("MGR", 7698). 
//    	         append("HIREDATE", "22-2月-81"). 
//    	         append("SAL", 1250).  
//    	         append("COMM ", 500). 
//    	         append("DEPTNO", 30);  
//        Document document4 = new Document
//    	        ("EMPNO", 7566).
//    	         append("ENAME", "JONES").
//    	         append("JOB", "MANAGER").  
//    	         append("MGR", 7839). 
//    	         append("HIREDATE", "02-4月-81"). 
//    	         append("SAL", 2975).  
////    	         append("COMM ", "database"). 
//    	         append("DEPTNO", 20);  
//        Document document5 = new Document
//    	        ("EMPNO", 75661).
//    	         append("ENAME", "JONES").
//    	         append("JOB", "MANAGER").  
//    	         append("MGR", 7839). 
//    	         append("HIREDATE", "02-4月-81"). 
//    	         append("SAL", 2975).  
////    	         append("COMM ", "database"). 
//    	         append("DEPTNO", 20);  
//        List<Document> documents = new ArrayList<Document>();  
//        documents.add(document);
//        documents.add(document2);
//        documents.add(document3);
//        documents.add(document4);
////        documents.add(document5);
//        return documents;
//	}
//}