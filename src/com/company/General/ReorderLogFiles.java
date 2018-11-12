package com.company.General;

import java.util.HashMap;

public class ReorderLogFiles {


    static int[] insertionSort(int[] a){


        for(int i=1;i<a.length;i++){
            int j=i;
            int temp = a[j];
            while(j>0 && temp < a[j-1]){
                a[j] = a[j-1];
                j--;
            }
            a[j] =temp;

        }

        return a;
    }

    public static String[] reorderLogFiles(String[] logs) {

        for(int i=1;i<logs.length;i++){
            int j=i;
            String tempj = logs[j];
            String tempj_1 = logs[j-1];
            String[] tempjString = tempj.split(" ");
            String[] tempj_1String = tempj_1.split(" ");

            while(j>0 && tempjString[1].compareTo(tempj_1String[1]) == -1){
                logs[j] = logs[j-1];
                j--;
            }
            logs[j] =tempj;

        }

        return logs;
    }

    public static void print(String[] arg){
        for(int i=0;i<arg.length;i++){
            System.out.println(arg[i] + ",");
        }
    }

    public static void main(String[] args){
        //["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
        String[] s = {"g1 act","g2 off","a8 act"};
       print(reorderLogFiles(s));
    }
}
