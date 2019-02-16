package com.company.General;

import java.util.*;

public class googleSample2 {


    static class Pair{
        int x;
        int y;
    }

    public static int solution(int[] S, int[] E) {

        if(S.length == 0 || E.length == 0 || S.length != E.length)
            return 0;

        Pair[] array = new Pair[S.length];

        for(int i=0;i<S.length;i++){
            Pair p = new Pair();
            p.x = S[i];
            p.y = E[i];
            array[i] = p;
        }

        Arrays.sort(array, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.x - o2.x;
            }
        });

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i].x)){
                int value = map.get(array[i].x);
                value++;
                map.replace(array[i].x,value);
            }else{
                map.put(array[i].x,1);
            }
            if(map.containsKey(array[i].y)){
                int value = map.get(array[i].y);
                value--;
                map.replace(array[i].y,value);
            }else{
                map.put(array[i].y,-1);
            }
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            int key = (int)pair.getKey();
            int value = (int) pair.getValue();

            sum = sum + value;
            if(sum > max){
                max = sum;
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[] S = {2,3,6,1,9,4};
        int[] E = {5,7,8,10,11,7};

        System.out.println(solution(S,E));
    }
}
