package com.company.General;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayofDoubledPairs {


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
            if(check.containsKey(A[i])){
                int value = check.get(A[i]);
                check.remove(A[i]);
                check.put(A[i],value+1);
            }else{
                check.put(A[i],1);
            }
        }



        for(int i=0;i<A.length;i++){
                int pair1 = A[i];
                if(check.containsKey(2*A[i])) {
                    int value = check.get(2*A[i]);
                    check.remove(2*A[i]);
                    if (A[i] == 2 * A[i]) {
                        value = value - 2;
                    } else {
                        value = value - 1;
                    }

                    if (value > 0) {
                        check.put(2*A[i], value);
                    }
                    count++;
                }
        }

       if(count == numPairs){
           return true;
       }else{
           return false;
       }
    }

    public static void main(String[] args){
        int[] a = {1,2,4,8};
        System.out.println(canReorderDoubled(a));
    }
}
