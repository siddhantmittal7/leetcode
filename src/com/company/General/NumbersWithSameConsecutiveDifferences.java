package com.company.General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    public static int[] numsSameConsecDiff(int N, int K) {

        if(N==1){
            int[] a = {0,1,2,3,4,5,6,7,8,9};
            return a;
        }

        List<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<10;i++){
            int j = i+K;
            if(j<10){
                if(i==0 && K!=0){
                    int num = 0;
                    int fact = 1;
                    int flag = 1;
                    if(N%2 == 0){
                        for(int k=0;k<N;k++){
                            if(flag == 1){
                                num = num + fact*i;
                                flag = 2;
                            }else {
                                num = num + fact*j;
                                flag = 1;
                            }
                            fact = fact*10;
                        }
                        list.add(num);
                    }else{
                        int temp = i;
                        i = j;
                        j = temp;
                        num = 0;
                        fact = 1;
                        flag = 1;
                        for(int k=0;k<N;k++){
                            if(flag == 1){
                                num = num + fact*i;
                                flag = 2;
                            }else {
                                num = num + fact*j;
                                flag = 1;
                            }
                            fact = fact*10;
                        }
                        list.add(num);
                        i = j;
                    }
                }else if(i!=0){
                    int num = 0;
                    int fact = 1;
                    int flag = 1;
                    for(int k=0;k<N;k++){
                        if(flag == 1){
                            num = num + fact*i;
                            flag = 2;
                        }else {
                            num = num + fact*j;
                            flag = 1;
                        }
                        fact = fact*10;
                    }
                    list.add(num);
                    if(i!=j){
                        int temp = i;
                        i = j;
                        j = temp;
                        num = 0;
                        fact = 1;
                        flag = 1;
                        for(int k=0;k<N;k++){
                            if(flag == 1){
                                num = num + fact*i;
                                flag = 2;
                            }else {
                                num = num + fact*j;
                                flag = 1;
                            }
                            fact = fact*10;
                        }
                        list.add(num);
                        i = j;
                    }
                }
            }
        }

        int[] array = new int[list.size()];

        int i=0;

        for(int l:list){
            array[i] = l;
            i++;
        }

        return array;
    }

    public static void main(String[] args){

        int[] ans = numsSameConsecDiff(2,1);
        System.out.println("hey");

    }
}
