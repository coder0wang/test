package com.coder.kkb.jvm;


class Entity{
    int a;
    int b;
    public Entity(int a,int b){
        this.a = a;
        this.b = b;
    }
}
/**
 * 此类描述的是：  
 * @author: Coder_Wang 
 * @version: 2019年4月30日 上午11:26:31
 */
public class TestObject {
    
    /**
     * 引用传递和值传递
     */
    
    public static void main(String[] args) {
        
        int num = 1;

        TestObject t = new TestObject();
        
        t.toNum(num);
        
        System.out.println(num);
        
        Entity e = new Entity(11,22);
        
        t.toEntityNum(e);
        
        System.out.println(e.a);
        
    }
    
    public void toNum(int num){
        num = 2;
    }
    
    public void toEntityNum (Entity e){
        e.a = 2;
    }
    
}
