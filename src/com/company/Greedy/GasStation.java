package com.company.Greedy;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int tank = 0;
        int startingStation = 0;
        int totalGas = 0;
        for(int i=0;i<gas.length;i++){
            tank = tank + gas[i] - cost[i];
            totalGas = totalGas + gas[i] - cost[i];

            if(tank <= 0){
                startingStation = i + 1;
                tank = 0;
            }
        }

        return totalGas < 0 ? -1 : startingStation;

    }

    public static void main(String[] args){

        int[] gas = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};

        System.out.print(canCompleteCircuit(gas,cost));

    }
}
