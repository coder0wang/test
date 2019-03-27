package com.wyd.nosql;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisUtil {
	public final static String IP_STRING = "192.168.117.101";
	public final static int PORT_STRING = 6301;
	private static JedisPool jedisPool;//非切片连接池
//	private static ShardedJedis shardedJedis;//切片额客户端连接
    private static ShardedJedisPool shardedJedisPool;//切片连接池
    public RedisUtil() 
    { 
    	initialPool() ;
        initialShardedPool(); 
//        shardedJedis = shardedJedisPool.getResource(); 
    } 
    
    
   
    
    /**
     * 初始化非切片池
     */
    private void initialPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxActive(20); 
        config.setMaxIdle(5); 
        config.setMaxWait(1000l); 
        config.setTestOnBorrow(false); 
        
        jedisPool = new JedisPool(config,IP_STRING,PORT_STRING);
    }
    /** 
     * 初始化切片池 
     */ 
    private void initialShardedPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxActive(20); 
        config.setMaxIdle(5); 
        config.setMaxWait(1000l); 
        config.setTestOnBorrow(false); 
        // slave链接 
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
        shards.add(new JedisShardInfo(IP_STRING,PORT_STRING, "master")); 
        // 构造池 
        shardedJedisPool = new ShardedJedisPool(config, shards); 
    } 
    
    public void testOverTime(){
    	ShardedJedis shardedJedis = shardedJedisPool.getResource(); 
    	shardedJedis.set("user_mac", "123");
    	shardedJedis.expire("user_mac",10);
//    	try{ 
//            Thread.sleep(2000); 
//        } 
//        catch (InterruptedException e){ 
//        } 
    	 // 查看某个key的剩余生存时间,单位【秒】.永久生存或者不存在的都返回-1
        System.out.println("查看key001的剩余生存时间："+shardedJedis.ttl("user_mac"));
        // 移除某个key的生存时间
//        System.out.println("移除key001的生存时间："+shardedJedis.persist("user_mac"));
        System.out.println("查看key001的剩余生存时间："+shardedJedis.ttl("user_mac"));
        // 查看key所储存的值的类型
        System.out.println("查看key所储存的值的类型："+shardedJedis.type("user_mac"));
        shardedJedisPool.returnResource(shardedJedis);
    }
    public void showTime(){
    	Jedis jedis = jedisPool.getResource(); 
    	try {
    		jedis.ttl("100000000116021");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jedisPool.returnResource(jedis);
		}
    
    }
    public void allKey (){
    	Jedis jedis = jedisPool.getResource(); 
  	  Set<String> keys = jedis.keys("*");//列出所有的key，查找特定的key如：redis.keys("foo")
  	   Iterator<String> t1=keys.iterator() ;
  	   while(t1.hasNext()){
  		 String obj1=t1.next();
  	    System.out.println(obj1);
  	   }
  }
    public static void flushDB(){
    	Jedis jedis = jedisPool.getResource(); 
    	try {
    		jedis.flushDB();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jedisPool.returnResource(jedis);
		}
    
    }
    public static void flushDB2(){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	try {
    		jedis.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    
    }
    public static void flushAll(){
    	Jedis jedis = jedisPool.getResource(); 
    	try {
    		jedis.flushAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jedisPool.returnResource(jedis);
		}
    
    }
    public  void testW() throws Exception{
//		Task task1 = new Task();
//		task1.setShardedJedisPool(shardedJedisPool );
//		task1.setKey("c6");
//		task1.setValue("66");
//		Thread thread1 = new Thread(task1);
//		Task task2 = new Task();
//		task2.setShardedJedisPool(shardedJedisPool );
//		task2.setKey("c7");
//		task2.setValue("77");
//		Thread thread2 = new Thread(task2);
//		thread1.wait();
//		thread2.wait();
//		thread1.run();
//		synchronized(thread1){
//			thread1.start();
//		}
//		this.notifyAll();
	}
    
    public static String ADD_FLAG = "add";
    public static String DEL_FLAG = "del";
    /**
     * <map操作>
     */
    public static void updateAddMap(String key,String field, String value){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	try {
			jedis.hset(key,field, value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
    public static void updateDelMap(String key,String field){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	try {
			jedis.hdel(key, field);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
    
    
    public static void updateAddMap(String key, Map<String, String> map){
//    	ShardedJedis jedis = shardedJedisPool.getResource();
//    	try {
//			Map<String,String> useMap = jedis.hgetAll(key);
//			useMap.putAll(map);
//			jedis.hmset(key, map);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			shardedJedisPool.returnResource(jedis);
//		}
    	Map<String,String> useMap = findMap(key);
    	useMap.putAll(map);
    	saveMap(key, useMap);
    }
    public static void updateDelMap(String key, Map<String, String> map){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	try {
			Map<String,String> useMap = jedis.hgetAll(key);
			for(String mapKey:map.keySet()){
				useMap.remove(mapKey);
			}
			jedis.hmset(key, map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
    /**
     * 更新map
     */
    public static void updateMap(String key, Map<String,Map<String,String>> map){
		try {
			for(String mapKey:map.keySet()){
				Map<String,String> tempMap = map.get(mapKey);
				//map中添加
				if(mapKey.equals(ADD_FLAG)){
					updateAddMap(key,tempMap);
				}
				//map中删除
				if(mapKey.equals(DEL_FLAG)){
					updateDelMap(key,tempMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void saveMap(String key, Map<String,String> map){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	try {
			jedis.hmset(key, map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
    public static String findMap(String key,String field){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	String str = null;
    	try {
    		str =jedis.hget(key,field);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    	return str;
    }
    public static Map<String,String> findMap(String key){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	Map<String,String> useMap = null;
    	try {
			 useMap = jedis.hgetAll(key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    	return useMap;
    }
    
    /**
     * </map操作>
     */
    /**
     * <list操作>
     */
    //单个添加
    public static void updateAddList(String key, String value){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	try {
    		jedis.rpush(key,value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
  //集合添加
    public static void updateAddList(String key, List<String> list){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	try {
    		String[] strs = new String[list.size()];
    		for (int i = 0; i < list.size(); i++) {
    			strs[i] = (String) list.get(i);
			}
			jedis.rpush(key, strs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
    //删除单个
    public static void updateDelList(String key, String value){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	try {
			jedis.lrem(key, 1,value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
    //!!! 删除集合
    public static void updateDelList(String key, List<String> list){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	try {
    		for (int i = 0; i < list.size(); i++) {
    			jedis.lrem(key, 1, list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
    /**
     * 更新map
     */
    public static void updateList(String key, Map<String,List<String>> map){
		try {
			for(String mapKey:map.keySet()){
				List<String> tempList = map.get(mapKey);
				//map中添加
				if(mapKey.equals(ADD_FLAG)){
					updateAddList(key,tempList);
				}
				//map中删除
				if(mapKey.equals(DEL_FLAG)){
					updateDelList(key,tempList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void saveListO(String key, List list){
    	 ShardedJedis jedis = shardedJedisPool.getResource();
     	try {
     		jedis.set(key.getBytes(), serialize(list));  
 		} catch (Exception e) {
 			e.printStackTrace();
 		}finally{
 			shardedJedisPool.returnResource(jedis);
 		}
    }
        public static byte[] serialize(List value) {  
            if (value == null) {  
                throw new NullPointerException("Can't serialize null");  
            }  
            byte[] rv=null;  
            ByteArrayOutputStream bos = null;  
            ObjectOutputStream os = null;  
            try {  
                bos = new ByteArrayOutputStream();  
                os = new ObjectOutputStream(bos);  
                for(Object user : value){  
                    os.writeObject(user);  
                }  
                os.writeObject(null);  
                os.close();  
                bos.close();  
                rv = bos.toByteArray();  
            } catch (IOException e) {  
                throw new IllegalArgumentException("Non-serializable object", e);  
            } finally {  
//                close(os);  
//                close(bos);  
            }  
            return rv;  
        }  
    public static void saveList(String key, List<String> list){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	try {
    		String[] strs = new String[list.size()];
    		for (int i = 0; i < list.size(); i++) {
    			strs[i] = (String) list.get(i);
			}
			jedis.lpush(key, strs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
    public static  List<String> findList(String key){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	 List<String> list  = null;
    	try {
    		list = jedis.lrange(key,0,-1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    	return list;
    }
    
    /**
     * </list操作>
     */
    /**
     * <set操作>
     */
    public static Set<String> findSet(String key){
    	ShardedJedis jedis = shardedJedisPool.getResource();
   	 	Set<String> set  = null;
	   	try {
	   		set = jedis.smembers(key);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				shardedJedisPool.returnResource(jedis);
			}
	   	return set;
    }
    public static void saveSet(String key,Set<String> set){
    	ShardedJedis jedis = shardedJedisPool.getResource();
	   	try {
	   		Object[] o = set.toArray(); 
	   		String[] strs = new String[o.length];
    		for (int i = 0; i < o.length; i++) {
    			strs[i] = (String) o[i];
			}
	   		jedis.sadd(key, strs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
    public static void updateAddSet(String key,String value){
    	ShardedJedis jedis = shardedJedisPool.getResource();
	   	try {
	   		jedis.sadd(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
    public static void updateDelSet(String key,String value){
    	ShardedJedis jedis = shardedJedisPool.getResource();
	   	try {
	   		jedis.srem(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			shardedJedisPool.returnResource(jedis);
		}
    }
    /**
     * </set操作>
     */
    /**
     * <value操作>
     */
    public static String findStr (String key){
    	ShardedJedis jedis = shardedJedisPool.getResource();
    	String str  = null;
	   	try {
//	   		boolean b= jedis.exists(key);
//	   		if(b)
	   			str = jedis.get(key);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				shardedJedisPool.returnResource(jedis);
			}
	   	return str;
    }
    public static void saveStr (String key,String value){
    	ShardedJedis jedis = shardedJedisPool.getResource();
	   	try {
	   			jedis.set(key,value);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				shardedJedisPool.returnResource(jedis);
			}
    }
    public static void delStr (String key){
    	ShardedJedis jedis = shardedJedisPool.getResource();
	   	try {
	   			Long a = jedis.del(key);
	   			System.out.println(a);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				shardedJedisPool.returnResource(jedis);
			}
    }
    /**
     * </value操作>
     */
}
