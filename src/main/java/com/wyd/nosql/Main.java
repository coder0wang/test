package com.wyd.nosql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        new RedisClient().show(); 
    	RedisUtil ru = new RedisUtil();
        try {
        	Map<String, Object> map = new HashMap<String, Object>();
        	map.put("id", "wolys");
        	map.put("pwd", "olysopen111");
        	map.put("email", "wolys@21cn.com");
        	Map<String, Object> map2 = new HashMap<String, Object>();
        	map2.put("id", "coralshanshan");
        	map2.put("pwd", "601601601");
        	map2.put("email", "zss1984@126.com");
        	List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        	list.add(map);
        	list.add(map2);
        	ru.saveListO("test", list);
//			new RedisClient().KeyOperate();
//			new RedisClient().r();
//        	new RedisUtil().testW();
//        	new RedisUtil().updateDel("asdasd","");
//        	RedisUtil util = new RedisUtil();
//        	Set<String> set = util.findSet("100000010539000");
//        	System.out.println(set.toString());
//        	util.testOverTime();
//        	Object a = util.findSet("100000010577000");
//        	System.out.println(a);
//        	Object b = util.findSet("100000010578000");
//        	System.out.println(b);
//        	util.delStr("188000000001");
//        	util.flushDB();
//        	util.flushDB2();
//        	util.allKey();
		} catch ( Exception e) {
			e.printStackTrace();
		}
    }

}