package com.company.General;

import java.util.HashMap;

public class VerifyinganAlienDictionary {

    public static boolean isAlienSorted(String[] words, String order) {

        if(words.length == 1){
            return true;
        }
        HashMap<Character,Integer> sortedMap = new HashMap<Character, Integer>();

        for(int i=0;i<order.length();i++){
            sortedMap.put(order.charAt(i),i);
        }

        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1 == word2)
                continue;
            if(word1.length() < word2.length()){
                for(int k=0;k<word1.length();k++){
                    if(word1.charAt(k) != word2.charAt(k)){
                        if(sortedMap.get(word1.charAt(k)) < sortedMap.get(word2.charAt(k))){
                            break;
                        }else{
                            return false;
                        }
                    }
                }
            }else{
                boolean check = false;
                for(int k=0;k<word2.length();k++){
                    if(word1.charAt(k) != word2.charAt(k)){
                        if(sortedMap.get(word1.charAt(k)) < sortedMap.get(word2.charAt(k))){
                            check = true;
                            break;
                        }else{
                            return false;
                        }
                    }
                }
                if(check == false){
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args){
        String[] words = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words,order));
    }
}
