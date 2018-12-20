package com.company.General;

import java.util.HashMap;

public class PrisonCells {

    public static int[] prisonAfterNDays(int[] cells, int N) {

        int i = 1;

        HashMap<int[],Integer> map = new HashMap<int[],Integer>();

        //int[] new_cells  = new int[cells.length];


        while(i<=N){

            map.put(cells,i);

            int[] new_cells  = new int[cells.length];

            for(int j=1;j<cells.length-1;j++){
                if(cells[j-1] == cells[j+1]){
                    new_cells[j] = 1;
                }else{
                    new_cells[j] = 0;
                }
            }
            i++;

            if(map.containsKey(new_cells)){
                int skip = map.get(new_cells);
                N = N%skip;
            }


            cells = new_cells;
        }

        return cells;
    }

    public static void printArray(int[] a){
        for(int j=0;j<a.length;j++){
            System.out.print(a[j]);
        }
    }
    public static void main(String[] args){

        int[] cells = {1,0,0,1,0,0,1,0};
        int N = 1000000000;

        printArray(prisonAfterNDays(cells,N));


    }
}
