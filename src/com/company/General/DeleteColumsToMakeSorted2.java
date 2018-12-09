package com.company.General;

import java.util.LinkedHashSet;
import java.util.Set;

public class DeleteColumsToMakeSorted2 {

    public static int minDeletionSize(String[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int d = 0;

        int colum = 0;

        Set<Integer> posUsed = new LinkedHashSet<Integer>();

        int i =0;
        int length = A.length;

        while(true){
            if(i > A.length - 2){
                break;
            }else{
                String word1 = A[i];
                String word2 = A[i+1];

                for(int k=0;k<word1.length();k++){
                    if(!posUsed.contains(k)){
                        if(word1.charAt(k) < word2.charAt(k)){
                            break;
                        }else if(word1.charAt(k) == word2.charAt(k)){
                            continue;
                        }else{
                            d++;
                            posUsed.add(k);
                            i = -1;
                            break;
                        }
                    }

                }
                i++;

            }

        }

        return d;
    }

    public static void main(String[] args){
        String[] A = {"doeeqiy","yabhbqe","twckqte"};
        System.out.println(minDeletionSize(A));
    }
}
