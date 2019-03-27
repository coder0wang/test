//package com.wyd.dispersed.lesson1;
//
//import java.io.IOException;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.fs.FSDataInputStream;
//import org.apache.hadoop.fs.FSDataOutputStream;
//import org.apache.hadoop.fs.FileStatus;
//import org.apache.hadoop.fs.FileSystem;
//import org.apache.hadoop.fs.Path;
// /**
//  * 
// 
// * @Title: Test.java 
// 
// * @Package com.wyd.dispersed.lesson1 
// 
// * @Description: TODO(用一句话描述该文件做什么) 
// 
// * @author Coder 
// 
// * @date 2015-12-28 上午12:38:21 
// 
// * @version V1.0
//  */
//
//public class Test {
//	public static void main(String[] args) throws IOException {
//        
//        String[] str = new String[]{"g:\\hadoop\\123.rmvb","hdfs://master:9000/user/hadoop/inccnt.java"};
//        Configuration conf = new Configuration();
//        FileSystem fileS= FileSystem.get(conf);
//        FileSystem localFile = FileSystem.getLocal(conf);  //得到一个本地的FileSystem对象
//         
//        Path input = new Path(str[0]); //设定文件输入保存路径
//        Path out = new Path(str[1]);  //文件到hdfs输出路径
//         
//        try{
//            FileStatus[] inputFile = localFile.listStatus(input);  //listStatus得到输入文件路径的文件列表
//            FSDataOutputStream outStream = fileS.create(out);      //创建输出流    
//            for (int i = 0; i < inputFile.length; i++) {
//                System.out.println(inputFile[i].getPath().getName());
//                FSDataInputStream in = localFile.open(inputFile[i].getPath());
//                 
//                byte buffer[] = new byte[1024];
//                int bytesRead = 0;
//                while((bytesRead = in.read(buffer))>0){  //按照字节读取数据
//                    System.out.println(buffer);
//                    outStream.write(buffer,0,bytesRead);
//                }
//                 
//                in.close();
//            }
//             
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//}
