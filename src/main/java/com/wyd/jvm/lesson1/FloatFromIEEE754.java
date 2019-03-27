package com.wyd.jvm.lesson1;
public class FloatFromIEEE754 {
        public static void main(String[] args)
        {
                String a = "11000001000100000000000000000000";
                float b = getFloatFromIEEE754(a);
                System.out.print(b);
        }
        
        public static float getFloatFromIEEE754(String a)
        { 
                int s = 1, e = 0, mmm = 0;
                float result = 0.0f, m = 0.0f;
                if(a.charAt(0) == '1') 
                        s = -1;
                e = Integer.parseInt(a.substring(1, 9), 2);
                mmm = Integer.parseInt(a.substring(9, 32), 2);
                
                System.out.println(s);
                System.out.println(e);
                System.out.println(mmm);
                
                for (int i=0; i< 23; i++ )
                {
                        int t = (mmm & (1 << (22-i))) >>> (22-i);
                        m += t * Math.pow(2, -1-i);
                }
                
                if(e == 0)
                        result = (float) (s * Math.pow(2, e-127) * m);
                else
                        result = (float) (s * Math.pow(2, e-127) * (m + 1));

                return result;
        }
}