package com.company.General;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Array_form {

    public static List<Integer> addToArrayForm(int[] A, int K){


        int num = 10;
        int size_counter = 0;

        Stack<Integer> s = new Stack<Integer>();

        while(K>0){
            int q = K/num;
            int rem = K%num;
            s.push(rem);
            K = q;
        }

        int[] B = new int[s.size()];
        int j=0;

        while(!s.isEmpty()){
            B[j] = s.pop();
            j++;
        }


        int carry = 0;
        int last = 0;

        Stack<Integer> s_new = new Stack<Integer>();

        int i = A.length-1;
        int k= B.length-1;

        while(i >= 0 || k >=0){
            int a = 0;
            int b = 0;

            if(i >= 0){
                a = A[i];
                i--;
            }
            if(k >=0){
                b = B[k];
                k--;
            }

            int sum = a + b + carry;
            carry = sum/10;
            s_new.push(sum%10);
        }

        if(carry != 0){
            s_new.push(carry);
        }

        List<Integer> return_list = new ArrayList<Integer>();

        while(!s_new.isEmpty()){
            return_list.add(s_new.pop());
        }

        return return_list;

    }

    public static void main(String[] str){
        int[] A = {1,2,3,4};
        int k = 8766;
        List<Integer> l = addToArrayForm(A,k);
        System.out.println("hello");

    }
}
