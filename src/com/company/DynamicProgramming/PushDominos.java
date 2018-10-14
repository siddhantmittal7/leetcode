package com.company.DynamicProgramming;

public class PushDominos {
    public static String pushDominoes(String dominoes) {


        for(int i=0; i<dominoes.length(); i++){
            if(dominoes.charAt(i) == '.'){
                if(i==0){
                    if(dominoes.charAt(i+1) == 'L')
                        dominoes =  dominoes.charAt(i+1) + dominoes.substring(1,dominoes.length()-1);
                }else if(i==dominoes.length()-1){
                    if(dominoes.charAt(i-1) == 'R')
                        dominoes = dominoes.substring(0,dominoes.length()-2) + dominoes.charAt(i+1);
                }else{

                    String s = dominoes.substring(0,i);
                    int dot_count = 2;
                    while(i<dominoes.length()){
                        i= i+1;
                        if(dominoes.charAt(i+1) == 'R'){

                        }else if(dominoes.charAt(i+1) == 'L'){

                        }
                    }




                    if(dominoes.charAt(i-1) == 'R' && dominoes.charAt(i+1) == 'L')
                        continue;
                    else if(dominoes.charAt(i-1) == 'L' && dominoes.charAt(i+1) == 'R')
                        continue;
                    else if(dominoes.charAt(i-1) == 'L' && dominoes.charAt(i+1) == 'L')
                        dominoes = dominoes.substring(0,i) + 'L' + dominoes.substring(i+1,dominoes.length());
                    else if(dominoes.charAt(i-1) == 'R' && dominoes.charAt(i+1) == 'R')
                        dominoes = dominoes.substring(0,i) + 'R' + dominoes.substring(i+1,dominoes.length());
                    else if(dominoes.charAt(i-1) == 'L' && dominoes.charAt(i+1) == '.'){
                        String s = dominoes.substring(0,i);
                        int dot_count = 2;
                        while(i<dominoes.length()){
                            i= i+1;
                            if(dominoes.charAt(i+1) == 'R'){

                            }else if(dominoes.charAt(i+1) == 'L'){

                            }
                        }
                    }
                        continue;
                    else if(dominoes.charAt(i-1) == 'R' && dominoes.charAt(i+1) == '.')
                        dominoes = dominoes.substring(0,i) + 'R' + dominoes.substring(i+2,dominoes.length());
                }
            }
        }

        return dominoes;
    }

    public static void main(String[] args){
        String s = ".L.R...LR..L..";

        System.out.print(pushDominoes(s));
    }
}
