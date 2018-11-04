package com.company.General;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class RecentCounter {


    public List<Integer> requestMap;


    public RecentCounter() {

        requestMap = new ArrayList<Integer>();
    }

    public int ping(int t) {

        requestMap.add(t);

        int value = t-3000;

        int reqCount = 0;

        for(int i=0;i<requestMap.size();i++){
            if(requestMap.get(i) >= value){
                reqCount++;
            }
        }

        return reqCount;
    }
}