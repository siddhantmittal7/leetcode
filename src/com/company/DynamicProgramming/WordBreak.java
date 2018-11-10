package com.company.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {


    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] f = new boolean[s.length()+1];

        f[0] = true;

        for(int i=0;i<s.length();i++){
            for(int j=0;j<i;j++){
                if(f[j] && wordDict.contains(s.substring(j,i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static void main(String[] args){
        String s = "applepenapple";
        //String[] dict = {"leet","code"};
        List<String> dict = new ArrayList<String>();
        dict.add("apple");
        dict.add("pen");

        System.out.print(wordBreak(s,dict));

    }
}
