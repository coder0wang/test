package com.wyd.jvm_new.lesson02;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Crash {

       public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
            
            List classLoaders = new ArrayList();
            
             while(true ) {
            	 System.out.println("123");
                  ClassLoader classLoader = new ClassLoader() {
                         @Override
                         public Class loadClass(String name) throws ClassNotFoundException {
                               if (!"com.wyd.jvm_new.lesson02.Crash" .equals(name)) {
                                     return super .loadClass(name);
                              }
                               try {
                              String url = "file:G:/myeclipse/com.wyd/jvm/src/main/java/com/wyd/jvm_new/lesson02/Crash.java" ;
                              URL myUrl = new URL(url);
                              URLConnection connection = myUrl.openConnection();
                              InputStream input = connection.getInputStream();
                              ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                              int data = input.read();

                              while(data != -1){
                                  buffer.write(data);
                                  data = input.read();
                              }
                              input.close();
                              byte[] classData = buffer.toByteArray();
                              return defineClass("com.wyd.jvm_new.lesson02.Crash" ,
                                      classData, 0, classData .length );
                          } catch (MalformedURLException e) {
                              e.printStackTrace();
                          } catch (IOException e) {
                              e.printStackTrace();
                          }
                               return null ;
                         }
                  };
                  classLoaders.add(classLoader);
                  classLoader.loadClass("com.wyd.jvm_new.lesson02.Crash");
            }
      }
}
