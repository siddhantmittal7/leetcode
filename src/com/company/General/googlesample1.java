package com.company.General;

public class googlesample1 {

    public static int solution(int[] A) {

        boolean[] evenJump = new boolean[A.length];

        boolean[] oddJump = new boolean[A.length];

        evenJump[A.length-1] = true;
        oddJump[A.length-1] = true;

        for(int i=A.length-2;i>=0;i--){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int j=i+1;j<A.length;j++){
                int temp = A[j] - A[i];
                if(temp < min && temp > 0){
                    min = temp;
                    index = j;
                }
            }
            if(index != -1){
                oddJump[i] = evenJump[index];
            }else{
                oddJump[i] = false;
            }

            min = Integer.MAX_VALUE;
            index = -1;
            for(int j=i+1;j<A.length;j++){
                int temp = A[i] - A[j];
                if(temp < min && temp > 0){
                    min = temp;
                    index = j;
                }
            }
            if(index != -1){
                evenJump[i] = oddJump[index];
            }else{
                evenJump[i] = false;
            }
        }

        int count = 0;

        for(int i=0;i<oddJump.length;i++){
            if(oddJump[i])
                count++;
        }

        return count;
    }


    public static void main(String[] args){

        int[] A = {10,13,12,14,15};

        System.out.println(solution(A));
    }
}
