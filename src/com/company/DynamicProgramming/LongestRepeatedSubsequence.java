package com.company.DynamicProgramming;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class LongestRepeatedSubsequence {


    public static String lengthOfLRS(String a) {

        if(a == null || a.length() == 0){
            return "";
        }

        List<String> l = new ArrayList<String>();


        l.add(a.substring(0,1));

        for(int i=1;i<a.length();i++){

            int max = 0;
            String maxString = "";
            for(int j=0;j<i;j++){
                if(l.get(j).length() > max && l.get(j).contains(String.valueOf(a.charAt(i)))){
                    max = l.get(j).length();
                    maxString = l.get(j);
                }
            }
            l.add(maxString);
        }

        String ans = "";
        for(int i=0;i<l.size();i++){
            if(l.get(i).length() > ans.length()){
                ans = l.get(i);
            }
        }
        return ans;


    }


    public static void main(String[] args){

        String nums = "aabbc";

        System.out.print(lengthOfLRS(nums));
    }
}
