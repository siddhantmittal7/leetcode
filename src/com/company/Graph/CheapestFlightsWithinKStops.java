package com.company.Graph;

import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

        public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

            int[] vertex = new int[n];


            for(int i=0;i<n;i++){
                vertex[i] = Integer.MAX_VALUE;
            }

            vertex[src] = 0;

            for(int i=0;i<=K;i++){
                int[] vertex_new = new int[n];
                for(int m=0;m<n;m++){
                    vertex_new[m] = Integer.MAX_VALUE;
                }
                vertex_new[src] = 0;
                for(int k=0;k<flights.length;k++){
                    int[] edge = flights[k];
                    int u = edge[0];
                    int v = edge[1];
                    int w = edge[2];
                    if(vertex[u] < Integer.MAX_VALUE){
                        if(vertex[v] > vertex[u] + w){
                            vertex_new[v] = vertex[u] + w;
                        }
                    }
                }
                for(int j=0;j<vertex.length;j++){
                    System.out.print(vertex[j] + " ");
                }
                vertex = vertex_new;
                System.out.println();
            }

            if(vertex[dst] < Integer.MAX_VALUE){
                return vertex[dst];
            }else{
                return -1;
            }
    }

    public static void main(String[] args){
        int n = 4;

        int[][] f = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        int src = 0;
        int dst = 3;
        int k = 1;

        /*
        5
[[4,1,1],[1,2,3],[0,3,2],[0,4,10],[3,1,1],[1,4,3]]
2
1
1
         */

        /*
        4

0
3
1
         */
        System.out.println(findCheapestPrice(n,f,src,dst,k));
    }
}
