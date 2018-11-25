package com.company.General;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumIncrementtoMakeArrayUnique {


    public static int returnDuplicate(int[] A){
        HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++){
            if(visited.containsKey(A[i])){
                return i;
            }else{
                visited.put(A[i],1);
            }
        }
        return -1;
    }

    public static int minIncrementForUnique(int[] A) {

        if(A == null || A.length == 0)
            return 0;

        int moves = 0;

        Arrays.sort(A);

        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                int j = i;
                while (j < A.length && A[j] <= A[j - 1]) {
                    A[j] = A[j] + 1;
                    j++;
                    moves++;
                }
            }
        }

        return  moves;
    }

    public static void main(String[] args){
        int[] a = {3,2,1,2,1,7};
                System.out.print(minIncrementForUnique(a));
    }
}
