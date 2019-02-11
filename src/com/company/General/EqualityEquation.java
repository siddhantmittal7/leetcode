package com.company.General;

import java.util.HashMap;

public class EqualityEquation {

    public static boolean equationsPossible(String[] equations) {

        HashMap<Character,Integer> map = new HashMap<Character, Integer>();


        int num = 1;


        for(int i=0;i<equations.length;i++){
            String s = equations[i];

            Character x = s.charAt(0);
            Character y = s.charAt(3);


            if(x == y){
                if(s.charAt(1) == '!')
                    return false;
            }else{

                if(s.charAt(1) == '='){
                    if(map.containsKey(x) && map.containsKey(y)){
                        if(map.get(x) != map.get(y)){
                            return false;
                        }
                    }else if(map.containsKey(x) && !map.containsKey(y)){
                        map.put(y,map.get(x));
                    } else if(!map.containsKey(x) && map.containsKey(y)){
                        map.put(x,map.get(y));
                    } else{
                        map.put(x,num);
                        map.put(y,num);
                    }
                }
            }
        }

        for(int i=0;i<equations.length;i++){
            String s = equations[i];

            Character x = s.charAt(0);
            Character y = s.charAt(3);


            if(x == y){
                if(s.charAt(1) == '!')
                    return false;
            }else{

                if(s.charAt(1) == '!'){
                    if(map.containsKey(x) && map.containsKey(y)){
                        if(map.get(x) == map.get(y)){
                            return false;
                        }
                    }else if(map.containsKey(x) && !map.containsKey(y)){
                        num++;
                        map.put(y,num);
                    } else if(!map.containsKey(x) && map.containsKey(y)){
                        num++;
                        map.put(x,num);
                    } else{
                        num++;
                        map.put(x,num);
                        num++;
                        map.put(y,num);

                    }
                }
            }
        }

        return true;
    }


    public static void main(String[] str){

        String[] s = {"e==e","d!=e","c==d","d!=e"};


        System.out.println(equationsPossible(s));
    }
}
