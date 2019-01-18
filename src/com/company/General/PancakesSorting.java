package com.company.General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakesSorting {

    public static int findmax(int[] A, int length){

        int max = Integer.MIN_VALUE;
        int max_index = 0;

        for(int i=0;i<length;i++){

            if(A[i] > max){
                max = A[i];
                max_index = i;
            }
        }

        return max_index;

    }

    public static int[] flip(int[] A, int index){
        for(int i=0;i<=index/2;i++){
            int temp = A[i];
            A[i] = A[index-i];
            A[index-i] = temp;
        }
        return A;
    }

    public static boolean issorted(int[] A){
        for(int i=0;i<A.length-1;i++){
            if(A[i] > A[i+1]){
                return false;
            }
        }

        return true;
    }
    public static List<Integer> pancakeSort(int[] A) {

        List<Integer> list = new ArrayList<Integer>();

        if(A == null || A.length == 0){
            return list;
        }

        int initial_length = A.length;

        int last_max_index = -2;

        int index = -1;

        while(!issorted(A)){
            index = findmax(A,initial_length);
            if(index != 0){
                list.add(index+1);
                flip(A,index);
            }
            list.add(initial_length);
            flip(A,initial_length-1);
            initial_length--;
        }

        return list;

    }

    public static void main(String[] args){
        int[] A = {1,2,3};

        List<Integer> ans = pancakeSort(A);

        System.out.println("hi");
    }
}
