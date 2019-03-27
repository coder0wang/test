package com.wyd.nosql.lesson10;
import java.io.File;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

public class MongoDBClientTest {

	public static void main(String[] args) {
//		initData();
//		query();
		initData4GridFS();
	}
	
	
	private static void initData4GridFS()   {
		long start = new Date().getTime();
		
		try {
			Mongo db = new Mongo("192.168.117.101", 10001);
			DB mydb = db.getDB("test");
			File f = new File("G://课程//noSql//第十课//NoSQL与NewSQL数据库引航10.pdf");
			GridFS myFS = new GridFS(mydb);             
			GridFSInputFile inputFile = myFS.createFile(f);
			inputFile.setId(1);
			inputFile.setFilename("test123");
			inputFile.save();

			DBCursor cursor = myFS.getFileList();
			while(cursor.hasNext()){
				System.out.println(cursor.next());
			}	
			db.close();
			long endTime = new Date().getTime();
			System.out.println(endTime - start);
			System.out.println((endTime - start) / 10000000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}