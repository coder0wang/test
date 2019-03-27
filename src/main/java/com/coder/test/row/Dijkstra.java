package com.coder.test.row;

public class Dijkstra {
 
    private static int N = 1000;
    
    private static int[][] Graph = {
            { 1, 2, 2 },
            { 2, 2, N },
            { 2, N, 2 },
            };
 
    public static void main(String[] args) {
        dijkstra(0, Graph);
    }
 
    /**
     * Dijkstra最短路径。
     */
    public static void dijkstra(int vs, int[][] Graph) {
        int NUM = Graph[0].length;
        // 前驱节点数组
        int[] prenode = new int[NUM];
        // 最短距离数组
        int[] mindist = new int[NUM];
        // 该节点是否已经找到最短路径
        boolean[] find = new boolean[NUM];
         
        int vnear = 0;
         
        for (int i = 0; i < mindist.length; i++) {
            prenode[i] = i;
            mindist[i] = Graph[vs][i];
            find[i] = false;
        }
 
        find[vs] = true;
 
        for (int v = 1; v < Graph.length; v++) {
            int min = N;
            for (int j = 0; j < Graph.length; j++) {
                if (!find[j] && mindist[j] < min) {
                    min = mindist[j];
                    vnear = j;
                }
            }
            find[vnear] = true;
            for (int k = 0; k < Graph.length; k++) {
                if (!find[k] && (min + Graph[vnear][k]) < mindist[k]) {
                    prenode[k] = vnear;
                    mindist[k] = min + Graph[vnear][k];
                }
            }
        }
         
        int sum = 0 ;
        for (int i = 0; i < NUM; i++) {
            System.out.println("v" + vs + "...v" + prenode[i] + "->v" + i + ", s=" + mindist[i]);
            sum +=mindist[i];
        }
        System.out.println("权重和为"+sum);
    }
}