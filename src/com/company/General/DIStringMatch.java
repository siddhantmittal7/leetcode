package com.company.General;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class DIStringMatch {

    public static int[] diStringMatch(String S) {

        if(S == null || S.length() == 0)
            return null;

        HashMap<Integer,Boolean> used = new HashMap<Integer,Boolean>();

        PriorityQueue<Integer> minPq = new PriorityQueue<Integer>();

        PriorityQueue<Integer> maxPq = new PriorityQueue<Integer>(Collections.reverseOrder());

        int N = S.length() + 1;

        for(int i=0;i<N;i++){
            used.put(i,false);
            minPq.add(i);
            maxPq.add(i);
        }



        int[] A = new int[N];

        if(S.charAt(0) == 'D'){
            while(true){
                int max = maxPq.remove();
                if(!used.get(max)){
                    A[0] = max;
                    used.replace(max,true);
                    break;
                }
            }
        }else{
            while(true){
                int min = minPq.remove();
                if(!used.get(min)){
                    A[0] = min;
                    used.replace(min,true);
                    break;
                }
            }
        }

        for(int i=0;i<S.length()-1;i++){
            if(S.charAt(i) == 'D' && S.charAt(i+1) == 'D'){
                while(true){
                    int max = maxPq.remove();
                    if(!used.get(max)){
                        A[i+1] = max;
                        used.replace(max,true);
                        break;
                    }
                }
            }else if(S.charAt(i) == 'I' && S.charAt(i+1) == 'I') {
                while(true){

                    int min = minPq.remove();
                    if(!used.get(min)){
                        A[i+1] = min;
                        used.replace(min,true);
                        break;
                    }
                }
            }else if(S.charAt(i) == 'I' && S.charAt(i+1) == 'D') {
                while(true){

                    int max = maxPq.remove();
                    if(!used.get(max)){
                        A[i+1] = max;
                        used.replace(max,true);
                        break;
                    }
                }
            }else if(S.charAt(i) == 'D' && S.charAt(i+1) == 'I') {
                while(true){

                    int min = minPq.remove();
                    if(!used.get(min)){
                        A[i+1] = min;
                        used.replace(min,true);
                        break;
                    }
                }
            }
        }

        Set<Integer> keyeset = used.keySet();

        for(Integer i:keyeset){
            if(!used.get(i))
                A[N-1] = i;
        }

        return A;
    }

    public static void main(String[] args){
        String s = "";

        System.out.println(diStringMatch(s));
    }
}
