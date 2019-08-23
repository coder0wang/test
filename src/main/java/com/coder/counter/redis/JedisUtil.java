package com.coder.counter.redis;



import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

//https://blog.csdn.net/qq_33556185/article/details/79427271
public class JedisUtil {
    
    
    
	private static  JedisPool jedisPool;
	
	@Autowired(required = true)
	public void setJedisPool(JedisPool jedisPool) {
		JedisUtil.jedisPool = jedisPool;
	}
	/**
	 * 对某个键的值自增
	 * @author liboyi
	 * @param key 键
	 * @param cacheSeconds 超时时间，0为不超时
	 * @return
	 */
	public static long setIncr(String key, int cacheSeconds) {
		long result = 0;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			result =jedis.incr(key);
			if (cacheSeconds != 0) {
			 jedis.expire(key, cacheSeconds);
			}
//			log.debug("set "+ key + " = " + result);
		} catch (Exception e) {
//			log.warn("set "+ key + " = " + result);
		} finally {
			jedisPool.returnResource(jedis);
		}
		return result;
	}
}	