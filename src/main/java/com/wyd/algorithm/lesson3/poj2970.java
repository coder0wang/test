package com.wyd.algorithm.lesson3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class poj2970 {
        private static int debug=0;
        private static int []  a;
        private static int []  b;
        private static int []  d;
        private static int []  t;
        private static int []  m;
        
        private static void printintary(int [] ary,String msg)
        {
                System.out.println(msg);
                for(int i=0;i<ary.length;i++)
                {
                        System.out.print(ary[i]+",");
                }
                System.out.println();
                return;
        }
        
        public static void printstatus()
        {
                if (debug==0) return;
                
                if (a.length>0) {
                        printintary(a,"a");
                        printintary(b,"b");
                        printintary(d,"d");        
                        printintary(d,"t");
                        printintary(d,"m");
                        
                }
                return;                
        }
        
        public static void initData(String fileName)
        {
             File file = new File(fileName);
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(file));
                    
                    String buff=reader.readLine();
                    if (null!=buff)
                    {
                            //System.out.println(buff);
                            int n=Integer.parseInt(buff);
                            d=new int[n];
                            b=new int[n];
                            a=new int[n];
                            t=new int[n];
                            m=new int[n];
                            
                            for(int i=0;i<n;i++)
                            {
                                    String [] tmpary;
                                    
                                    buff=reader.readLine();
                                    if (null!=buff){
                                            tmpary=buff.split(" ");
                                            if (tmpary.length>=3) {
                                                    a[i]=Integer.parseInt(tmpary[0]);
                                                    b[i]=Integer.parseInt(tmpary[1]);
                                                    d[i]=Integer.parseInt(tmpary[2]);
                                                    t[i]=0;m[i]=0;
                                            } else
                                            {
                                                    System.out.println("Invalid Data"+buff);
                                                    continue;
                                            }
                                    } else
                                    {
                                            System.out.println("NULL line at line: "+(i+1));
                                    }
                            }                
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e1) {
                        }
                    }
                }                        
        }
        
        public static int pupplesort()
        {
                int i,j,minpos;
                int t;
                
                for(i=0;i<d.length;i++)
                {
                        minpos=i;
                        for(j=i;j<d.length;j++)
                        {
                                if (d[j]<d[minpos]) {
                                        t=d[j];d[j]=d[minpos];d[minpos]=t;
                                        t=a[j];a[j]=a[minpos];a[minpos]=t;
                                        t=b[j];b[j]=b[minpos];b[minpos]=t;
                                }
                                
                        }
                }
                return 0;                
        }
        
        public static int getmaxposition(int [] ary,int len)
        {
                int maxpos=0;
                for(int i=0;i<len;i++)
                        if (ary[i]>ary[maxpos]) {
                                maxpos=i;                                
                        }
                
                return maxpos;
        }
        
        public static int sumarray(int[] ary,int len)
        {
                int sum=0;
                for(int i=0;i<len;i++)
                        sum=sum+ary[i];
                
                return sum;
        }
        
        public static int calcmoney()
        {
                int i,totalday;
                
                pupplesort();
                printstatus();
                
                for(i=0;i<d.length;i++)
                {
                        
                        t[i]=b[i];
                        totalday=sumarray(t,i+1);
                        while(totalday>d[i]) {
                                int pos=getmaxposition(a,i+1);//找到最大性价比的合同
                                int miss=totalday-d[i];
                                if (t[pos]>=miss) {//找到最大性价比的合同，用最小的钱加快进度
                                        m[pos]=m[pos]+miss/a[pos];
                                        t[pos]=t[pos]-miss;
                                        break;
                                } else {
                                        m[pos]=t[pos]/a[pos];
                                        t[pos]=0;//这个合同已经不可能更快了,所以将所需时间和系数都清0
                                        a[pos]=0; 
                                }
                                totalday=sumarray(t,i+1);
                        }
                }
                
                return sumarray(m,m.length);
                
        }

        
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                initData("src/algorithms/poj2970in.txt");
                printstatus();
                System.out.println("min money is "+calcmoney());

        }
}