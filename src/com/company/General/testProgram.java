package com.company.General;

import java.util.*;

public class testProgram {

    public static List<String> run(String inputString, int k){

        List<String> returnStr = new ArrayList<String>();


        for(int i=0;i<inputString.length();i++){
            if(i+k-1 == inputString.length()){
                break;
            }
            int[] arr = new int[26];
            Arrays.fill(arr,0);
            for(int j=i;j<i+k;j++){
                arr[inputString.charAt(j) - 'a']++;
            }
            int ans = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[j] > 0){
                    ans = ans + 1;
                }
            }

            if(ans == k-1){
                returnStr.add(inputString.substring(i,i+k));
            }
        }

        return returnStr;
    }

    public static void main(String[] args){
        String s = "democracy";
        int num = 5;

        System.out.println(run(s,num));
    }
}
