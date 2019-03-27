package test.clss;

import java.util.Date;

public class Hot {
    public void hot(String aaa){
        System.out.println("~~~~~~~~ version 1 : "+this.getClass().getClassLoader());
        System.out.println(aaa + "   "+new Date());
    }
}