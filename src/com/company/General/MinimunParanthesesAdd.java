package com.company.General;

import java.util.Stack;

public class MinimunParanthesesAdd {

    public int minAddToMakeValid(String S) {

        Stack<Character> stack = new Stack<Character>();

        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '('){
                stack.add(S.charAt(i));
            }
            if(S.charAt(i) == ')'){
                if(stack.size() > 0 && stack.peek() == '(')
                    stack.pop();
                else
                    stack.add(S.charAt(i));
            }
        }

        return stack.size();



    }
}
