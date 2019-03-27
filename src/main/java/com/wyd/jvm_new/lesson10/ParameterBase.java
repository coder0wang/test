package com.wyd.jvm_new.lesson10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
public class ParameterBase
{
    /**
     * Get Class field and value Map
     * @return
     */
    public Map<String, String> getClassInfo()
    {
        Map<String ,String>  fieldsAndValues = new HashMap<String, String>();
        Field [] fields = this.getClass().getDeclaredFields();
        for(int i=0; i< fields.length; i++)
        {
            Field f = fields[i];
            String value = getFieldValue(this ,f.getName()).toString();
            fieldsAndValues.put(f.getName(),value);
        } 
      return fieldsAndValues;
    }  

    

    private  String getFieldValue(Object owner, String fieldName)
    {
        return invokeMethod(owner, fieldName,null).toString();
    }

    
    /**
     * 
     * 执行某个Field的getField方法
     * 
     * @param owner 类
     * @param fieldName 类的属性名称
     * @param args 参数，默认为null
     * @return 
     */
    private   Object invokeMethod(Object owner, String fieldName, Object[] args)
    {
        Class<? extends Object> ownerClass = owner.getClass();

        //fieldName -> FieldName  
        String methodName = fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);

        Method method = null;
        try 
        {
            method = ownerClass.getMethod("get" + methodName);
        } 
        catch (SecurityException e) 
        {
            //e.printStackTrace();
        } 
        catch (NoSuchMethodException e) 
        {
            // e.printStackTrace();
            return "";
        }

        //invoke getMethod
        try
        {
            return method.invoke(owner);
        } 
        catch (Exception e)
        {
            return "";
        }
    }
}
