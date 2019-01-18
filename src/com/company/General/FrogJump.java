package com.company.General;

import java.util.HashMap;

public class FrogJump {

    public static boolean helper(HashMap<Integer,Integer> stonesMap, int jump, int pos, int lastStone, boolean[][] c){

        if(c[stonesMap.get(pos)][jump]){
            return true;
        }else{
            if(jump < 1){
                c[stonesMap.get(pos)][jump] = false;
                return c[stonesMap.get(pos)][jump];
            }

            if(stonesMap.containsKey(jump + pos)) {
                if ((jump + pos) == lastStone) {
                    c[stonesMap.get(pos)][jump] = true;
                    return c[stonesMap.get(pos)][jump];
                } else {
                    c[stonesMap.get(jump + pos)][jump - 1] = helper(stonesMap, jump - 1, jump + pos, lastStone, c);
                    c[stonesMap.get(jump + pos)][jump] = helper(stonesMap, jump, jump + pos, lastStone, c);
                    c[stonesMap.get(jump + pos)][jump + 1] = helper(stonesMap, jump + 1, jump + pos, lastStone, c);
                    if (c[stonesMap.get(jump + pos)][jump - 1] ||
                            c[stonesMap.get(jump + pos)][jump] ||
                            c[stonesMap.get(jump + pos)][jump + 1]) {
                        c[stonesMap.get(pos)][jump] = true;
                        return c[stonesMap.get(pos)][jump];
                    } else {
                        c[stonesMap.get(pos)][jump] = false;
                        return c[stonesMap.get(pos)][jump];
                    }
                }
            }else {
                c[stonesMap.get(pos)][jump] = false;
                return c[stonesMap.get(pos)][jump];
            }
        }

    }

    public static boolean canCross(int[] stones) {

        HashMap<Integer,Integer> stonesMap = new HashMap<Integer,Integer>();

        for(int i=0;i<stones.length;i++){
            stonesMap.put(stones[i],i);
        }

        int lastStone =stones[stones.length-1];

        boolean[][] c = new boolean[stones.length+1][stones.length+1];



        return helper(stonesMap,1,0,lastStone,c);

    }

    public static void main(String[] args){
        int[] stone = {0,1,3,4,5,7,9,10,12};

        System.out.println(canCross(stone));
     }
}
