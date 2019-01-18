package com.company.General;

public class FindtheDifference {
    public static char findTheDifference(String s, String t) {

        int[] map = new int[26];

        for (int i=0;i<t.length();i++){
            int c = t.charAt(i);
            map[c-97] = map[c-97] + 1;
        }

        for (int i=0;i<s.length();i++){
            int c = s.charAt(i);
            if(map[c-97] > 0){
                map[c-97] = map[c-97] - 1;
            }
        }

        for(int i=0;i<map.length;i++){
            if(map[i] > 0){
                return (char)(i+97);
            }
        }
        return 0;
    }

    public static void main(String[] args){
        String s = "abcd";
        String t = "abcde";

        System.out.println(findTheDifference(s,t));
    }
}
