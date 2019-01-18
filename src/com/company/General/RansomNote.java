package com.company.General;

import java.util.HashMap;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] arr = new int[26];

        for(int i=0;i<magazine.length();i++){

            int ch = magazine.charAt(i) - 97;
            arr[ch] = arr[ch] + 1;
        }

        for(int j=0;j<ransomNote.length();j++){
            int ch = ransomNote.charAt(j) - 97;
            if(arr[ch] > 0){
                arr[ch]--;
            }else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(canConstruct("a","cba"));
    }
}
