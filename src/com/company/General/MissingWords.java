package com.company.General;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingWords {


    public static List<String> missingWords(String s1, String s2){


        String[] helpS1 = s1.split(" ");
        String[] helpS2 = s2.split(" ");

        List<String> finallist = new ArrayList<String>();

        int s1_counter = 0;

        for(int i=0;i<helpS2.length;i++){
            String searchword = helpS2[i];

            for(int j=s1_counter;j<helpS1.length;j++){
                if(searchword.equals(helpS1[j])){
                    s1_counter = j+1;
                    break;
                }else{
                   finallist.add(helpS1[j]);
                }
            }
        }

        for(int j=s1_counter;j<helpS1.length;j++){
            finallist.add(helpS1[j]);
        }

        return finallist;

    }

    public static void main(String[] args){
        String s1 = "I am Siddhant Mohan Mittal";
        String s2 = "I Siddhant";

        List<String> ans = missingWords(s1,s2);
    }
}
