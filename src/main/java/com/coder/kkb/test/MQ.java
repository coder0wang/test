package com.coder.kkb.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 此类描述的是：  
 * @author: Coder_Wang 
 * @version: 2019年3月30日 下午6:44:00
 */
public class MQ {
    
    Map<String,String> map = new HashMap<String,String>();
    
    /**
     * 下单方法
     * 
     * 验证库存
     * 支付验证
     * 生成订单
     * 
     */
    
    /**
     * 最初情况
     */
    public void submitOrder1(){
        //验证库存
        
        /**
         * 代码。。。。
         */
        
        //支付验证
        
        /**
         * 代码。。。。
         */
        
        //生成订单
        
        /**
         * 代码。。。。
         */
        
    }
    
    /**
     * 系统拆分，互相调用
     */
    public void submitOrderA(){
        
        //验证库存
        
        /**
         * 代码。。。。
         * REST/RPC
         */
        
        //支付验证
        
        /**
         * 代码。。。。
         * REST/RPC
         */
        
        //生成订单
        
        /**
         * 代码。。。。
         * REST/RPC
         */
        
    }
    

}
