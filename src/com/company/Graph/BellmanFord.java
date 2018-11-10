package com.company.Graph;

public class BellmanFord {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int[] vertex = new int[n];


        for(int i=0;i<n;i++){
            vertex[i] = Integer.MAX_VALUE;
        }

        vertex[src] = 0;

        for(int i=1;i<n-1;i++){
            for(int k=0;k<n;k++){
                int[] edge = flights[k];
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(vertex[v] > vertex[u] + w){
                    vertex[v] = vertex[u] + w;
                }
            }
        }

        return vertex[dst];
    }

    public static void main(String[] args){
        int n = 3;

        int[][] f = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 1;

        System.out.println(findCheapestPrice(n,f,src,dst,k));
    }
}
