package com.company.General;

import java.util.Stack;

public class DecodeString {


    public static String decodeHelper(int num, String s){
        String ans = "";
        while(num>0){
            ans = ans + s;
            num--;
        }
        return ans;
    }

    public static String decodeString(String s) {

        Stack<Character> stack = new Stack<Character>();

        String ans = "";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ']'){
                String helper = "";
                while(true){
                    char c = stack.pop();
                    if(c == '['){
                        String numString = "";
                        while(!stack.isEmpty() && stack.peek() <= 57 && stack.peek() >=48){
                            numString = stack.pop() + numString;
                        }
                        int num = Integer.valueOf(numString);
                        String reply = decodeHelper(num,new StringBuilder(helper).reverse().toString());
                        for(int j=0;j<reply.length();j++){
                            stack.add(reply.charAt(j));
                        }
                        break;
                    }
                    helper = helper + c;
                }
            }else{
                stack.add(s.charAt(i));
            }
        }

        while(!stack.isEmpty()){
            ans = stack.pop() + ans;
        }

        return ans;

    }



    public static void main(String[] args){
        String s =
                "3[a]2[bc]";
        String t = "ahbgdc";

        System.out.println(decodeString(s));
    }
}
