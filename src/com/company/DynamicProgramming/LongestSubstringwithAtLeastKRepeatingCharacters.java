package com.company.DynamicProgramming;

import java.util.HashMap;
import java.util.regex.Matcher;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public static int helper(HashMap<Character,Integer> map,String s, int k){
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) < k){
                if(i == 0){
                    return helper(map,s.substring(i+1,s.length()),k);
                }else if(i == s.length() - 1){
                    return helper(map,s.substring(0,i),k);
                }else{
                    return Math.max(helper(map,s.substring(0,i),k),helper(map,s.substring(i+1,s.length()),k));
                }
            }
        }

        return s.length();
    }
    public static int longestSubstring(String s, int k) {

        if(s == null || s.length() == 0){
            return 0;
        }

        int[] map = new int[26];

        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-97]++;
        }


        for(int i=0;i<s.length();i++){
            if(map[s.charAt(i)-97] < k){
                if(i == 0){
                    return longestSubstring(s.substring(i+1,s.length()),k);
                }else if(i == s.length() - 1){
                    return longestSubstring(s.substring(0,i),k);
                }else{
                    return Math.max(longestSubstring(s.substring(0,i),k),longestSubstring(s.substring(i+1,s.length()),k));
                }
            }
        }

        return s.length();
    }

    public static void main(String[] args){
        String s = "ababbc";
        int k = 2;
        System.out.println(longestSubstring(s,k));
    }
}
