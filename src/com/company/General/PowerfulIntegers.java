package com.company.General;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {


        Set<Integer> list = new LinkedHashSet<Integer>();
        for(int i=0;i<=18 & Math.pow(x,i) <= bound;i++){
            for(int j=0;j<=18 & Math.pow(y,j) <= bound;j++){
                int new_num = (int)(Math.pow(x,i) + Math.pow(y,j));
                if( new_num <= bound){
                    list.add(new_num);
                }
            }
        }

        List<Integer> list_new = new ArrayList<Integer>();

        for(int s:list){
            list_new.add(s);
        }

        return list_new;
    }

    public static void main(String[] args){
        int x = 2; int y = 3; int bound = 10;
        List<Integer> s = powerfulIntegers(x,y,bound);
        System.out.println("hello0");

    }
}
