package com.company.General;

public class MinimumAreaRectangle {

    public static int minAreaRect(int[][] points) {

        for(int i=0;i<points.length;i++){
            int[] temp = points[i];
            int j = i;
            while(j>0 && temp[0] < points[j][0]){
                    points[j] = points[j-1];
                    j--;
                }
                points[j] =temp;
        }

        int min_area = Integer.MAX_VALUE;

        for(int i=0;i<points.length-1;i++){
            if(points[i][0] == points[i+1][0]){
                int y1 = points[i][1];
                int y2 = points[i+1][1];
                for(int j=i+1;j<points.length-1;j++){
                    if(y1 == points[j][1] && y2 == points[j+1][1] && points[j][0] == points[j+1][0]){
                        int area = Math.abs((y2-y1)*(points[j][0]*points[i][0]));
                        min_area = Math.min(min_area,area);
                    }
                }
            }
        }

        return min_area;
    }

    public static void main(String[] args){
        int[][] j = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        System.out.println(minAreaRect(j));
    }
}
