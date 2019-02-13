package com.company.General;

public class BrokenCalculator {

    public static int helper(int X, int Y) {

        if(X == Y){
            return 0;
        }
        if(X>0 && X<2*Y){
            return Math.min(helper(X-1,Y)+1, helper(2*X,Y)+1);
        }else{
            return Integer.MAX_VALUE;
        }


    }

    public static int brokenCalc(int X, int Y) {

        return helper(X,Y);
    }

    public static void main(String[] args){
         System.out.println(brokenCalc(2,3));
    }


}
