package com.company.General;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                if(!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(')
                    stack.pop();
                else if(!stack.isEmpty() && s.charAt(i) == ']' && stack.peek() == '[')
                    stack.pop();
                else if(!stack.isEmpty() && s.charAt(i) == '}' && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }


    public static void main(String[] args){

        System.out.print(isValid("("));
    }
}
