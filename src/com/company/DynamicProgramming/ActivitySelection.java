package com.company.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelection {

    public static int activitySelection(int[] s, int[] f,int[] l, int k,List<Integer> activites){

        if(l[k] > 0)
            return l[k];

        if(activites.size() == 0){
            return 0;
        }

        if(k==0)
            return 0;

        List<Integer> comp_activities = new ArrayList<Integer>();

        for(int i=0;i<s.length;i++){
            if(f[i] < s[k])
                comp_activities.add(i);
        }

          activites.remove(k);


        l[k] = Math.max(activitySelection(s,f,l,k-1,comp_activities)+1,activitySelection(s,f,l,k-1,activites));

        return l[k];
    }


    public static void main(String[] args){

        int[] s = {2,2,1,6};
        int[] f = {5,4,6,8};

        List<Integer> activities = new ArrayList<Integer>();

        for(int i=0;i<s.length;i++){
            activities.add(i);
        }

        int[] l = new int[s.length+1];

        System.out.print(activitySelection(s,f,l,s.length-1,activities));
    }
}
