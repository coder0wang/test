package com.wyd.algorithm.lesson7;
import com.mongodb.DB;//加载MongoDB的java驱动
import com.mongodb.Mongo;
 
public class Connection {
    public static void main(String[] args) throws Exception {
        Mongo m = new Mongo("localhost", 27017);
        DB db = m.getDB("test");
        if(db.collectionExists("test")){
            System.out.println("success");;
        }
        else System.out.println("false");
    }
}