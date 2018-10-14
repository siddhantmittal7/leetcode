package com.company.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {

        if(triangle == null || triangle.size() == 0)
            return 0;

        for(int i=triangle.size()-1;i>0;i--){
            for(int j=1;j<=i;j++){
                int left = triangle.get(i).get(j-1);
                int right = triangle.get(i).get(j);
                int value = triangle.get(i-1).get(j-1);
                triangle.get(i-1).set(j-1,value + Math.min(left,right));
            }
        }

        return triangle.get(0).get(0);

    }

    public static void main(String[] args){
        //List<List<Integer>> value = [[2],[3,4],[6,5,7],[4,1,8,3]];

        //List<List<Integer>> list = new List<List<Integer>>();

        List<Integer> l = new ArrayList<Integer>();
        l.add(2);
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(3);
        l1.add(4);
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(6);
        l2.add(5);
        l2.add(7);
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(4);
        l3.add(1);
        l3.add(8);
        l3.add(3);

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        list.add(l);
        list.add(l1);
        list.add(l2);
        list.add(l3);




        System.out.print(minimumTotal(list));
    }
}
