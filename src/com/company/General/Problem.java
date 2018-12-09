package com.company.General;

import java.util.*;

//Your submission should *ONLY* use the following class name
public class Problem
{
//    public static void main(String[] args)
//    {
//
//        Scanner stdin = new Scanner(System.in);
//        while(stdin.hasNextLine())
//        {
//            HashMap<String, List<String>> possibleParentMap = new HashMap<String, List<String>>();
//            HashMap<String,Integer> possibleDefaulters = new HashMap<String,Integer>();
//            String input = stdin.nextLine();
//            String[] splitinput = input.split(" ");
//            int candies = Integer.valueOf(splitinput[0]);
//            int record = Integer.valueOf(splitinput[1]);
//
//            for(int  i=1;i<=record;i++){
//                String inputRecord = stdin.nextLine();
//                String[] splitinputRecord = inputRecord.split(" ");
//                int newCandiesCount = Integer.valueOf(splitinputRecord[0]);
//                if(newCandiesCount == candies){
//                    if(splitinputRecord.length == 2){
//                        possibleDefaulters.remove(splitinputRecord[0]);
//                    }else{
//                        for(int j=1;j<splitinputRecord.length;j++){
//                            if(possibleParentMap.containsKey(splitinputRecord[j])){
//                                List<String> possibleParents = possibleParentMap.get(splitinputRecord[j]);
//                                for(int k=1;k<splitinputRecord.length;k++){
//                                    if(k != j && !possibleParents.contains(splitinputRecord[k])){
//                                        possibleParents.add(splitinputRecord[k]);
//                                    }
//                                }
//                                possibleParentMap.remove(splitinputRecord[j]);
//                                possibleParentMap.put(splitinputRecord[j],possibleParents);
//                            }else{
//                                List<String> possibleParents = new ArrayList<String>();
//                                for(int k=1;k<splitinputRecord.length;k++){
//                                    if(k != j){
//                                        possibleParents.add(splitinputRecord[k]);
//                                    }
//                                }
//                                possibleParentMap.put(splitinputRecord[j], possibleParents);
//                            }
//                        }
//                    }
//                }else{
//                    candies = newCandiesCount;
//                    for(int j=1;j<splitinputRecord.length;j++){
//                        if(possibleParentMap.containsKey(splitinputRecord[j])){
//                            List<String> possibleParents = possibleParentMap.get(splitinputRecord[j]);
//                            boolean parent_match = false;
//                            for(int k=1;k<splitinputRecord.length;k++){
//                                if(k != j && possibleParents.contains(splitinputRecord[k])){
//                                    parent_match = true;
//                                    break;
//                                }
//                            }
//                            if(parent_match == false){
//                                if(possibleDefaulters.containsKey(splitinputRecord[j])){
//                                    int value =  possibleDefaulters.get(splitinputRecord[j]);
//                                    possibleDefaulters.remove(splitinputRecord[j]);
//                                    possibleDefaulters.put(splitinputRecord[j],value+1);
//                                }else{
//                                    possibleDefaulters.put(splitinputRecord[j],1);
//                                }
//                            }
//                        }else{
//                            if(possibleDefaulters.containsKey(splitinputRecord[j])){
//                                    int value =  possibleDefaulters.get(splitinputRecord[j]);
//                                possibleDefaulters.remove(splitinputRecord[j]);
//                                possibleDefaulters.put(splitinputRecord[j],value+1);
//                            }else{
//                                possibleDefaulters.put(splitinputRecord[j],1);
//                            }
//                        }
//                    }
//                }
//            }
//
//            int maxValue = Integer.MIN_VALUE;
//            String  theGuy = "";
//
//            if(possibleDefaulters.size() == 0){
//                System.out.println("UNKNOWN");
//                return;
//            }else{
//                Set<String> keys = possibleDefaulters.keySet();
//
//                for(String s:keys){
//                    int value = possibleDefaulters.get(s);
//                    if(value == maxValue){
//                        System.out.println("UNKNOWN");
//                        return;
//                    }
//                    if(value > maxValue){
//                        maxValue = value;
//                        theGuy =  s;
//                    }
//                }
//
//            }
//
//            System.out.println(theGuy + " UNKNOWN");
//            return;
//        }
//        stdin.close();
//    }

    public static void main(String[] args)
    {

        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNextLine())
        {
            int booths = Integer.valueOf(stdin.nextInt());
            int noOfgroups = Integer.valueOf(stdin.nextInt());

            int[] available = new int[booths];
            int[] lastEntry = new int[booths];
            int[] count = new int[booths];

            int i =0;
            int groupSize = Integer.valueOf(stdin.nextInt());
            while(stdin.hasNextLine()){
                for(int j=0;j<available.length;j++) {
                    if (i > 0 && i>=available[j] && available[j] != 0){
                        lastEntry[j] = available[j];
                        if(count[j]%10 ==0 && count[j] != 0)
                            available[j] = 5 + lastEntry[j];
                        else
                            available[j] = 0;
                    }
                }
                for(int j=0;j<available.length;j++) {
                    if (available[j] == 0) {
                        available[j] = groupSize + lastEntry[j];
                        count[j] = count[j] + 1;
                        if(stdin.hasNextLine())
                            groupSize = Integer.valueOf(stdin.nextInt());
                        else
                            break;
                    }
                }
                i++;
            }
            for(int j=0;j<count.length-1;j++){
                System.out.print(count[j] + " ");
            }
            System.out.println(count[count.length-1]);
        }
        stdin.close();
    }
}