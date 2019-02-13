package com.company.General;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> ans = new ArrayList<String>();


        for(int i=0;i<words.length;i++) {
            String s = words[i];
            HashMap<Character, Character> map = new HashMap<Character, Character>();
            HashMap<Character, Character> map2 = new HashMap<Character, Character>();
            if (s.length() == pattern.length()) {
                String check = "";
                for (int j = 0; j < s.length(); j++) {
                    Character c = s.charAt(j);
                    if (map.containsKey(c)) {
                        if(map2.containsKey(map.get(c))){
                            if(map2.get((map.get(c))) == c){
                                check = check + map.get(c);
                            }
                        }else{
                            check = check + map.get(c);
                        }
                    } else {
                        if(map2.containsKey(pattern.charAt(j))){
                            break;
                        }else{
                            map.put(c, pattern.charAt(j));
                            map2.put(pattern.charAt(j),c);
                            check = check + pattern.charAt(j);
                        }
                    }
                }
                if (check.equals(pattern)) {
                    ans.add(s);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        String[] asdf =  {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";

        List<String> ans = findAndReplacePattern(asdf,pattern);
        System.out.println("hello");
    }
}
