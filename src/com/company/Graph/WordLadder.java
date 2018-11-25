package com.company.Graph;

import java.util.*;

public class WordLadder {


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<String>();
        HashMap<String,Integer> transHash = new HashMap<String,Integer>();
        int trans = 1;
        while(true){
            List<String> updatedList = new ArrayList<String>();
            if(beginWord == endWord){
                return trans;
            }

            for(int i=0;i<wordList.size();i++){
                String nextWord = wordList.get(i);
                if(nextWord.length() == beginWord.length()){
                    int count = 0;
                    for(int j=0;j<nextWord.length();j++) {
                        if (nextWord.charAt(j) != beginWord.charAt(j)) {
                            count++;
                        }
                    }
                    if(count == 1) {
                        q.add(nextWord);
                        //updatedList.remove(nextWord);
                        transHash.put(nextWord,trans+1);
                    }else if (nextWord.equals(beginWord)) {
                        continue;
                    }
                    else{
                        updatedList.add(nextWord);
                    }
                }else{
                    //updatedList.remove(nextWord);
                }
            }

            if(q.isEmpty() && !beginWord.equals(endWord))
                return 0;

            beginWord = ((LinkedList<String>) q).getFirst();
            ((LinkedList<String>) q).removeFirst();
            trans =  transHash.get(beginWord);
            wordList = updatedList;
        }
    }

    public static void main(String[] args){
        List<String> wordList = new ArrayList<String>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");

        System.out.println(ladderLength("a","c",wordList));

    }
}
