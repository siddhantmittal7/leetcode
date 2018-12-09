package com.company.General;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayofDoubledPairs {

    public static int findmatch(int[] A, int value, int index, Set<Integer> posUsed){

        if(!posUsed.contains(index)){
            if(index == 0 || index == A.length-1){
                if(A[index] == value) {
                    return index;
                }
                else{
                    return -1;
                }
            }

            if(A[index] == value){
                return index;
            }else if (A[index] > value){
                return findmatch(A, value, index/2,posUsed);
            }else{
                return findmatch(A, value, A.length-index/2,posUsed);
            }
        }else{
            return -1;
        }

    }

    public static boolean canReorderDoubled(int[] A) {

        if(A == null || A.length == 0)
            return true;

        Arrays.sort(A);

        int length = A.length;
        int numPairs = length/2;

        int count = 0;

        Set<Integer> posUsed = new LinkedHashSet<Integer>();


        HashMap<Integer,Integer> check = new HashMap<Integer,Integer>();

        for(int i=0;i<A.length;i++){
            if(!posUsed.contains(i)){
                int pair1 = A[i];
                int pos = findmatch(A,2*pair1,A.length/2,posUsed);
                if( pos > -1){
                    if(i != pos && !posUsed.contains(pos)){
                        posUsed.add(i);
                        posUsed.add(pos);
                        count++;
                    }
                }
            }
        }

       if(count == numPairs){
           return true;
       }else{
           return false;
       }
    }

    public static void main(String[] args){
        int[] a = {0,0,0,0,0,0};
        System.out.println(canReorderDoubled(a));
    }
}
