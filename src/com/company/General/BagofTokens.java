package com.company.General;

import java.util.Arrays;

public class BagofTokens {

    public static int bagOfTokensScore(int[] tokens, int P) {

        if(tokens.length == 0){
            return 0;
        }

        int points = 0;

        Arrays.sort(tokens);

        if(P < tokens[0])
            return points;

        int smallest = 0;
        int sum = 0;

        for(smallest=0;smallest<tokens.length;smallest++){
            if(P >= tokens[smallest]){
                P = P-tokens[smallest];
                points++;
            }else{
                break;
            }
        }

        int largest = tokens.length;

        while(smallest < largest){
            if(largest-smallest < 3){
                while(smallest < largest){
                    if(P >= tokens[smallest]){
                        P = P-tokens[smallest];
                        points++;
                    }
                    smallest++;
                }
                break;
            }else{
                if(P < tokens[largest-1]){
                    P = P+tokens[largest-1];
                    points--;
                    largest--;
                }
                int i =0;
                for(i=smallest;i<tokens.length;i++){
                    if(P >= tokens[i]){
                        P = P-tokens[i];
                        points++;
                    }else{
                        break;
                    }
                }
                smallest = i;
            }
        }

        return points;
    }

    public static void main(String[] args){
        int[] tokens = {68,85,34,25,60};
        int P = 44;
        System.out.println(bagOfTokensScore(tokens,P));

    }
}
