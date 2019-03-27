package com.wyd.interview.interview11;
public class prim {
 /*
  * m:定义为无法到达的距离
  * weight:邻接矩阵表,weight表示权值
  * verNum:顶点的个数
  * lowerW:到新集合的最小权值
  * edge:存储到新集合的边
  * checked:判定顶点是否被抽取的集合
  */
 static int INF=Integer.MAX_VALUE;
 static int[][] weight={
	   {0  ,1  ,4  ,INF,INF,INF},  
	   {1  ,0  ,1  ,5  ,INF,INF},  
	   {4  ,1  ,0  ,2  ,3  ,INF},  
	   {INF,5  ,2  ,0  ,INF,6  },  
	   {INF,INF,3  ,INF,0  ,2  } ,  
	   {INF,INF,INF,6  ,2  ,0}  
 };
 static int verNum=weight.length;
 static int []lowerW=new int[verNum];
 static int []edge=new int[verNum];
 static boolean []checked=new boolean[verNum];
 
 public void prim(int n,int [][]w){
  checked[0]=true;            //抽取第一个顶点
  
  for(int i=1;i<=n;i++){          //初始化顶点集合
   lowerW[i]=w[1][i];
   edge[i]=1;
   checked[i]=false;
  }
  
  for(int i=1;i<=n;i++){
   int min=Integer.MAX_VALUE;
   int j=0;
   for(int k=2;k<=n;k++){        //判定是否抽取该顶点
    if(lowerW[k]<min&&(!checked[k])){
     min=lowerW[k];
     j=k;
    }
   }
//   System.out.println(j+"-->"+edge[j]);
   System.out.println(edge[j]+"-->"+j);
   checked[j]=true;           //将顶点加入到新集合中
   
   for(int k=2;k<=n;k++){        //根据新加入的顶点，求得最小的权值
    if((w[j][k]<lowerW[k])&&(!checked[k])){
     lowerW[k]=weight[j][k];
     edge[k]=j;
    }
   }
  }
 }
 
 public static void main(String[] args) {
  prim p=new prim();
  p.prim(verNum-1,weight);
 }
}