package com.company.General;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sameregions {


    public static class pair{
        int x;
        int y;
    }

    public static boolean flag;




    public static int countMatches(List<String> grid1, List<String> grid2) {
        // Making it simpler to perform dfs on the the girds by converting to matrix form

        int[][] s1 = new int[grid1.size()][grid1.get(0).length()];
        int[][] s2 = new int[grid2.size()][grid2.get(0).length()];

        for(int i=0;i<grid1.size();i++){
            for(int j=0;j<grid1.get(i).length();j++){
                if(grid1.get(i).charAt(j) == '1'){
                    s1[i][j] = 1;
                }else{
                    s1[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < grid2.size(); i++) {
            for (int j = 0; j < grid2.get(i).length(); j++) {
                if (grid2.get(i).charAt(j) == '1') {
                    s2[i][j] = 1;
                } else {
                    s2[i][j] = 0;
                }
            }
        }

        int[][] visited = new int[s1.length][s1[0].length];

        for(int i=0;i<s1.length;i++){
            for(int j=0;j<s1[0].length;j++){
                visited[i][j] = s1[i][j] + s2[i][j];
            }
        }

        List<List<pair>> list = new ArrayList<List<pair>>();


        for(int i=0;i<s1.length;i++){
            for(int j=0;j<s1[0].length;j++){
                if(s1[i][j] == 1){
                    List<pair> result = new ArrayList<pair>();
                    dfs(s1,i,j,result);
                    list.add(result);
                }
            }
        }

        int count = 0;

        int num = 0;

        for(int i=0;i<list.size();i++){

            List<pair> r = list.get(i);

            flag = true;

            dfs_test(s2,  r.get(0).x, r.get(0).y,r,0);

            if(flag){
                num++;
            }

        }

        return num;

    }


    public static void dfs_test(int[][] X, int i, int j, List<pair> list,int num){

        if(num >= list.size()){
            flag = false;
            return;
        }else{
            if(flag != false){
                X[i][j] = 2;
            }

            pair p = list.get(num);

            int m = p.x;
            int n = p.y;

            if(m != i || n != j){
                flag = false;
                return;
            }

            if (j - 1 >= 0 && X[i][j - 1] == 1) {
                dfs_test(X, i, j - 1,list,++num);
            }

            if (i - 1 >= 0 && X[i - 1][j] == 1) {
                dfs_test(X, i - 1, j,list,++num);
            }

            if (i + 1 < X.length && X[i + 1][j] == 1) {
                dfs_test(X, i + 1, j,list,++num);
            }

            if (j + 1 < X[0].length && X[i][j + 1] == 1) {
                dfs_test(X, i, j + 1,list,++num);
            }
        }




    }


    public static void dfs(int[][] X, int i, int j, List<pair> dfs_list){

        X[i][j] = 2;

        pair p = new pair();

        p.x = i;
        p.y = j;

        dfs_list.add(p);

        if (j - 1 >= 0 && X[i][j - 1] == 1) {
            dfs(X, i, j - 1,dfs_list);
        }

        if (i - 1 >= 0 && X[i - 1][j] == 1) {
            dfs(X, i - 1, j,dfs_list);
        }

        if (i + 1 < X.length && X[i + 1][j] == 1) {
            dfs(X, i + 1, j,dfs_list);
        }

        if (j + 1 < X[0].length && X[i][j + 1] == 1) {
            dfs(X, i, j + 1,dfs_list);
        }

    }

    public static boolean dfs_check(int[][] X, int i, int j, int num) {

        X[i][j] = num;

        if (j - 1 >= 0 && X[i][j - 1] == 2) {
            dfs_check(X, i, j - 1,num);
        } else if (j - 1 >= 0 && (X[i][j - 1] == 1 || (X[i][j - 1] > 2 &&  X[i][j - 1] < num))) {
            return false;
        }

        if (i - 1 >= 0 && X[i - 1][j] == 2) {
            dfs_check(X, i - 1, j,num);
        } else if (i - 1 >= 0 && (X[i - 1][j] == 1 || (X[i-1][j] > 2 &&  X[i-1][j] < num))){
            return false;
        }

        if (i + 1 < X.length && X[i + 1][j] == 2) {
            dfs_check(X, i + 1, j,num);
        } else if (i + 1 < X.length && (X[i + 1][j] == 1 || (X[i+1][j] > 2 &&  X[i+1][j] < num))){
            return false;
        }

        if (j + 1 < X[0].length && X[i][j + 1] == 2) {
            dfs_check(X, i, j + 1,num);
        } else if (j + 1 < X[0].length && (X[i][j + 1] == 1 || (X[i][j + 1] > 2 &&  X[i][j + 1] < num))) {
            return false;
        }

        return true;
    }


    public static void main(String[] str){

        List<String> A = new ArrayList<String>();
        List<String> B = new ArrayList<String>();

//        A.add("00101");
//        A.add("01110");
//        A.add("01000");
//        A.add("10110");
//        A.add("00000");
//        A.add("00101");
//        A.add("01110");
//        A.add("01000");
//        A.add("10110");
//
//        B.add("00101");
//        B.add("01110");
//        B.add("01100");
//        B.add("11110");
//        B.add("00000");
//        B.add("00101");
//        B.add("01110");
//        B.add("01000");
//        B.add("10110");

        A.add("001");
        A.add("011");
        A.add("100");

        B.add("001");
        B.add("011");
        B.add("101");

        System.out.println(countMatches(A,B));

    }


}
