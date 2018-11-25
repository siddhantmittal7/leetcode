package com.company.General;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if(pushed.length == 0)
            return false;

        Stack<Integer> s = new Stack<Integer>();
        int popped_seq = 0;

        for(int i =0;i<pushed.length;i++){
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek() == popped[popped_seq]){
                popped_seq++;
                s.pop();
            }
        }

        if(s.isEmpty())
            return true;
        else
            return false;
    }
}
