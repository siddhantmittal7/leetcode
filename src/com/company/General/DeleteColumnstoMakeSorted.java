package com.company.General;

public class DeleteColumnstoMakeSorted {

    public static int minDeletionSize(String[] A) {

        if(A == null || A.length == 0){
            return 0;
        }

        int d = 0;

            for(int j=0;j<A[0].length();j++) {
                for (int i = 0; i < A.length-1; i++) {
                    if(A[i].charAt(j) > A[i+1].charAt(j)) {
                        d++;
                        break;
                    }
                }
            }
            return d;
    }

    public static void main(String[] args){
        String[] s = {"zyx"};
        System.out.println(minDeletionSize(s));
    }

}
