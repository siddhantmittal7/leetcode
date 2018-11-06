package com.company.General;

public class LongestCommonPrefix {

    public static String lcpHelper(String s1,String s2){

        int breakingString = 0;
        String returnString = "";

        if(s1.length() > s2.length()){
                for(int i=0;i<s2.length();i++){
                    if(s1.charAt(i) != s2.charAt(i)){
                        breakingString = i;
                        break;
                    }
                    breakingString = i+1;
                }
                returnString = s1.substring(0,breakingString);
        }else{
                for(int i=0;i<s1.length();i++){
                    if(s1.charAt(i) != s2.charAt(i)){
                        breakingString = i;
                        break;
                    }
                    breakingString = i+1;
                }
                returnString = s2.substring(0,breakingString);

        }


        return returnString;
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0 || strs == null){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }else{
            String matchString = lcpHelper(strs[0],strs[1]);

            if(matchString != ""){
                for(int i=2;i<strs.length;i++){
                    matchString = lcpHelper(matchString,strs[i]);
                }
            }

            return matchString;
        }
    }

    public static void main(String[] args){
        String[] strs = {"flower","flow","dog"};
        System.out.println(longestCommonPrefix(strs));
    }
}

