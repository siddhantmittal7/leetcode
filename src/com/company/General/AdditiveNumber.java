package com.company.General;

public class AdditiveNumber {
    public static boolean isAdditiveNumber(String num) {

        if(num == null && num.length() == 0){
            return false;
        }

        if(num.length() < 3 || num.charAt(0) == '0'){
            return false;
        }

        for(int i=2;i<num.length();i++){
            int a = Integer.valueOf(num.charAt(i)) - 48;
            int b = Integer.valueOf(num.charAt(i-1)) - 48;
            int c = Integer.valueOf(num.charAt(i-2)) - 48;
            if( a != b + c){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        String num = "199100199";

        System.out.println(isAdditiveNumber(num));
    }
}
