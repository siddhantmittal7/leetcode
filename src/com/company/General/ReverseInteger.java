package com.company.General;

public class ReverseInteger {
    public static int reverse(int x) {

        int y = 0;
        int p1 = 10;
        String s = "";

        while(true){
            if(x<9){
                s = s + String.valueOf(x);
                 break;
            }

            int d = x/p1;
            int r = x%p1;
            s = s + String.valueOf(r);
            x = d;
        }

        if(s.length() > 4){
            return 0;
        }else{
            return Integer.valueOf(s);
        }

    }

    public static void main(String args[]){
        System.out.print(reverse(
                1534236469));
    }
}
