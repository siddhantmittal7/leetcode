package com.company.General;

import java.util.Arrays;

public class ValidMountainArray {

    public static boolean isIncreasing(int[] A){

        for(int i=0;i<A.length-1;i++){
            if(A[i] > A[i+1])
                return false;
        }

        return true;
    }

    public static boolean isDecreasing(int[] A){

        for(int i=0;i<A.length-1;i++){
            if(A[i] < A[i+1])
                return false;
        }

        return true;
    }

    public static boolean validMountainArray(int[] A) {

        if(A == null || A.length < 3)
            return false;

        int peekPoint = 0;

        for(int i=0;i<A.length-1;i++){
            if(A[i] >= A[i+1]){
                peekPoint = i;
                break;
            }
        }

        if(peekPoint == 0 || peekPoint == A.length-1)
            return false;

        for(int i=peekPoint;i<A.length-1;i++){
            if(A[i] <= A[i+1]){
                return false;
            }
        }

        return true;
//
//        int mid = 0;
//
//        while(true){
//
//            if(A.length < 3){
//                break;
//            }
//            if(A.length%2 == 0){
//                mid = A.length/2-1;
//            }else{
//                mid = A.length/2;
//            }
//
//            if(A[mid-1] < A[mid] && A[mid] > A[mid+1]){
//                if(isIncreasing(Arrays.copyOfRange(A,0,mid)) && isDecreasing(Arrays.copyOfRange(A,mid,A.length)))
//                    return true;
//                else
//                    return false;
//            }
//            if(A[mid-1] < A[mid] && A[mid] < A[mid+1]){
//                if()
//                A = Arrays.copyOfRange(A,mid,A.length);
//            }else if(A[mid-1] > A[mid] && A[mid] > A[mid+1]){
//                A = Arrays.copyOfRange(A,0,mid);
//            }else{
//                break;
//            }
//        }
//
//        return false;
    }


    public static void main(String[] args){
        int[] a = {2,5,5,3};
        System.out.println(validMountainArray(a));
    }
}
