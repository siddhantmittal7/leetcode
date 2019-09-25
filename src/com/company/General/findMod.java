package com.company.General;


import java.util.*;

public class findMod {

//        public static List<String> junctionBoxSort(List<String> list) {
//
//                List<String> old = new ArrayList<String>();
//                List<String> newList = new ArrayList<String>();
//
//                for(int i=0;i<list.size();i++){
//                        String s = list.get(i);
//                        String[] arr = s.split(" ");
//                        if(arr[1].charAt(0) > 96){
//                                old.add(s);
//                        }else{
//                                newList.add(s);
//                        }
//                }
//
//                if(root == null)
//                        return root;
//
//                if(root.val > R){
//                        return trimBST(root.left,L,R);
//                }
//
//                if(root.val < L){
//                        return trimBST(root.right,L,R);
//                }
//
//                root.left = trimBST(root.left, L, R);
//
//                root.right = trimBST(root.right,L,R);
//
//                return root;
//
//                Collections.sort(old,new Comparator<String>(){
//                        @Override
//                        public int compare(final String lhs,String rhs) {
//                                String[] arrlhs = lhs.split(" ",2);
//                                String[] arrrhs = rhs.split(" ",2);
//                                if(arrlhs[1].equals(arrrhs[1])){
//                                        return arrlhs[0].compareTo(arrrhs[0]);
//                                }else{
//                                        return arrlhs[1].compareTo(arrrhs[1]);
//                                }
//                        }
//                });
//
//                List<String> returnList = new ArrayList<String>();
//
//                returnList.addAll(old);
//                returnList.addAll(newList);
//
//                return returnList;
//
//        }

        public static int helper(int[] cost, int[] mem, int i){
                if(mem[i] > -1)
                        return mem[i];

                if(i < 2)
                        return 0;

                mem[i] = Math.min(helper(cost,mem,i-1) + cost[i-1],helper(cost,mem,i-2) + cost[i-2]);

                return mem[i];

        }
        public static int minCostClimbingStairs(int[] cost) {

                int n = cost.length;

                int[] mem = new int[n+2];

                for(int i=0;i<n+2;i++){
                        mem[i] = -1;
                }

                return helper(cost,mem,n);
        }


        public static List<Integer> splitIntoFibonacci(String s) {


                List<Integer> myList = new ArrayList<Integer>();

                int length = s.length();

                int max = length/3;

                boolean done = true;

                for(int j=max;j>=1;j--){
                        done = true;
                        for(int i=0;i<length;){
                                int num1 = Integer.parseInt(s.substring(i,i+j));
                                int num2 = Integer.parseInt(s.substring(i+j,i+j+j));

                                int value = 0;
                                if(String.valueOf(num1+num2).length() > j){
                                        value++;
                                }
                                int num3 = Integer.parseInt(s.substring(i+j+j,i+j+j+j+value));
                                if((num1 + num2) != num3){
                                        done = false;
                                        myList.clear();
                                        break;
                                }
                                else{


                                                myList.add(num1);


                                }
                                if(i+j+j+j >= length-1){
                                        myList.add(num2);
                                        myList.add(num3);
                                        break;

                                }

                                i=i+j;
                        }
                        if(done == true)
                                break;
                }

                return myList;

        }


        static class pair{
                int p1;
                int p2;
        }

        public static int lenLongestFibSubseq(int[] A) {

                int l = A.length + 1;
                pair[] end = new pair[l];
                int[] mem = new int[l];

                pair v = new pair();
                v.p1 = 0;
                v.p2 = A[0];

                mem[0] = 1;
                end[0] = v;

                pair v1 = new pair();
                v1.p1 = A[0];
                v1.p2 = A[1];

                mem[1] = 2;
                end[1] = v1;

                for(int n=2;n<A.length;n++){
                        int max = 0;

                        pair p = new pair();

                        for(int i=0;i<n;i++){
                                if(mem[i] >= max){
                                        max = mem[i];
                                        p.p1 = end[i].p1;
                                        p.p2 = end[i].p2;
                                        if(end[i].p1 + end[i].p2 == A[n]){
                                                max = mem[i] + 1;
                                                p.p1 = end[i].p2;
                                                p.p2 = A[n];
                                        }
                                }
                        }

                        if(max > 0){
                                mem[n] = max;
                                end[n] = p;
                        }
                }


                return mem[l-2];

        }

        public static int[] zeroOneCount(String s){
                int[] arr = new int[2];

                for(int i=0;i<s.length();i++){
                        if(s.charAt(i) == '0')
                                arr[0]++;
                        if(s.charAt(i) == '1')
                                arr[1]++;
                }

                return arr;
        }

        public static int helper(int[][][] mem, int m, int n, int k, String[] strs){
                if(m == 0 && n==0 || k==strs.length)
                        return 0;

                if(mem[m][n][k] > 0)
                        return mem[m][n][k];


                int[] arr = zeroOneCount(strs[k]);

                int val = helper(mem,m,n,k+1,strs);

                if(m-arr[0] >= 0 && n-arr[1] >=0){
                      val   = Math.max(val,helper(mem,m-arr[0],n-arr[1],k+1,strs) +1);
                }

                mem[m][n][k] = val;
                return mem[m][n][k];
        }
        public static int findMaxForm(String[] strs, int m, int n) {


                int[][][] mem = new int[m+1][n+1][strs.length+1];

                return helper(mem,m,n,0,strs);


        }

        static HashMap<String,Boolean> state = new HashMap<String,Boolean>();

        public static boolean willIWinAtThisState(int maxChoosableInteger, int desiredTotal, boolean[] used){

                if(desiredTotal<= 0)
                        return true;

                String currState = Arrays.toString(used);

                if(state.containsKey(currState)){
                        return state.get(currState);
                }

                for(int i=1;i<=maxChoosableInteger;i++){
                        if(used[i] == false){
                                used[i] = true;
                                if(!willIWinAtThisState(maxChoosableInteger,desiredTotal-i,used)){
                                        state.put(currState,true);
                                        used[i] = false;
                                        return true;
                                }
                                used[i] = false;
                        }
                }
                state.put(currState,false);
                return false;
        }
        public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {

                if(desiredTotal <= maxChoosableInteger)
                        return true;

                if (((1 + maxChoosableInteger) / 2 * maxChoosableInteger) < desiredTotal) {
                        return false;
                }

                boolean[] used = new boolean[maxChoosableInteger+1];

                return willIWinAtThisState(maxChoosableInteger, desiredTotal, used);


        }

        public static int findNumberOfLIS(int[] nums) {

                if(nums == null || nums.length == 0)
                        return 0;

                int[] mem = new int[nums.length];
                int[] count = new int[nums.length+1];

                mem[0] = 1;

                for(int i=1;i<nums.length;i++){
                        int max = 1;
                        for(int j=0;j<i;j++){
                                if(nums[i] > nums[j]){
                                        int val = mem[j] + 1;
                                        if(val > max)
                                                max = val;
                                }
                                mem[i] = max;
                        }
                }


                for(int i=0;i<mem.length;i++){
                        count[mem[i]]++;
                }

                int max1 = 0;
                for(int i=0;i<count.length;i++){
                        if(count[i] > max1)
                                max1 = count[i];
                }

                return max1;

        }

        public static void addToMap(String s,HashMap<String,Integer> map){
                if(map.containsKey(s)){
                        int val = map.get(s);
                        map.replace(s,val+1);
                }else{
                        map.put(s,1);
                }
        }

        public static HashMap<String,Integer> merge(HashMap<String,Integer> map1,HashMap<String,Integer> map2){
                HashMap<String,Integer> returnMap = new HashMap<String,Integer>();
                returnMap.putAll(map1);
                for(String s:map2.keySet()){
                        if(map1.containsKey(s)){
                                returnMap.put(s,map2.get(s) + map1.get(s));
                        }else{
                                returnMap.put(s,map2.get(s));
                        }
                }

                return returnMap;
        }

        public static String longestDupSubstring(String S) {
                HashMap<String,Integer> myMap = new HashMap<String,Integer>();

                HashMap<String,Integer> helperMap = new HashMap<String,Integer>();

                myMap.put(S.substring(0,1),1);
                helperMap.put(S.substring(0,1),1);

                for(int i=1;i<S.length();i++){
                        HashMap<String,Integer> newMap = new HashMap<String,Integer>();
                        addToMap(String.valueOf(S.charAt(i)),newMap);
                        for(String sub:helperMap.keySet()){
                                String ans = sub + S.charAt(i);
                                addToMap(ans,newMap);
                        }
                        myMap = merge(newMap,myMap);
                        helperMap = newMap;
                }

                int max = 0;
                String maxS = "";
                for(String s:myMap.keySet()){
                        if(myMap.get(s) > 1 && maxS.length() < s.length()){
                                max = myMap.get(s);
                                maxS = s;
                        }
                }

                return maxS;
        }


        public List<String> topKFrequent(String[] words, int k) {

                HashMap<String,Integer> map = new HashMap<String,Integer>();

                for(int i=0;i<words.length;i++){
                        if(map.containsKey(words[i])){
                                int val = map.get(words[i]);
                                map.replace(words[i],val+1);
                        }else{
                                map.put(words[i],1);
                        }
                }

                List<Map.Entry<String, Integer>> myList = new ArrayList<Map.Entry<String,Integer>>();

                for(Map.Entry<String,Integer> m : map.entrySet()){
                        myList.add(m);
                }

                Collections.sort(myList,new Comparator<Map.Entry<String,Integer>>(){
                        public int compare(Map.Entry<String,Integer> m1, Map.Entry<String,Integer> m2){
                                return m1.getValue().compareTo(m2.getValue());
                        }
                });

                String[] arr = new String[k];
                List<String> returnList = new ArrayList<String>();

                for(int i=myList.size()-1;i>=myList.size()-k-1;i--){

                        returnList.add(myList.get(i).getKey());
                }

                return returnList;
        }


//        static HashMap<Integer,Integer> used;
//
//        static int[][] dp;
//
//        public static int helper(int i, int j, int[] nums){
//
//                if(i>j)
//                        return 0;
//
//                if(dp[i][j] > 0)
//                        return dp[i][j];
//
//                int max = 0;
//                for(int k=i;k<=j;k++){
//                        if(!used.containsKey(nums[k])){
//                                used.put(nums[k]-1,used.getOrDefault(nums[k]-1,0)+1);
//                                used.put(nums[k]+1,used.getOrDefault(nums[k]+1,0)+1);
//                                int val = helper(i,k-1,nums) + helper(k+1,j,nums) + nums[k];
//                                if(val > max)
//                                        max = val;
//                        }
//                }
//
//                dp[i][j] = max;
//                return dp[i][j];
//
//        }

//        static int[] dp;
//
//        public static int helper(int n){
//                if(n <= 0 || n>dp.length-1)
//                        return 1;
//
//                if(dp[n] > 0)
//                        return dp[n];
//
//                int max = 0;
//                for(int i=1;i<=n/2;i++){
//                        int val = Math.max((n-i)*i,Math.max((n-i)*helper(i),Math.max(helper(n-i)*i,helper(n-i)*helper(i))));
//                        if(val > max)
//                                max = val;
//                }
//
//                dp[n] = max;
//                return max;
//        }
//        public static int integerBreak(int n) {
//                dp = new int[n+1];
//                dp[1] = 1;
//                dp[0] = 0;
//                return helper(n);
//        }


//        static int[] ugly;
//
//        public static int helper(int n){
//
//                if(ugly[n] > 0)
//                        return ugly[n];
//
//                        int val = Math.min(helper(n-1)*2,Math.min(helper(n-1)*3,helper(n-1)*5));
//
//                ugly[n] = val;
//                return ugly[n];
//        }
//
//        public static int nthUglyNumber(int n) {
//                ugly = new int[n+1];
//
//                ugly[1] = 1;
//
//                return helper(n);
//        }


//        public static int pathfinder(int i, int j, int[][] grid){
//
//                if(i==0 && j==0)
//                        return 0;
//
//                if(dp[i][j] > 0)
//                        return dp[i][j];
//
//                int val = 0;
//
//                if(i-1>=0 && grid[i-1][j] == 0){
//                        val = val + pathfinder(i-1,j,grid);
//                }
//
//                if(j-1>=0 && grid[i][j-1] == 0){
//                        val = val + pathfinder(i,j-1,grid);
//                }
//
//                dp[i][j] = val;
//
//                return dp[i][j];
//
//        }
//
//        public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
//
//                if(obstacleGrid == null || obstacleGrid.length ==0)
//                        return 0;
//
//                int m = obstacleGrid.length-1;
//                int n = obstacleGrid[0].length-1;
//
//                //System.out.println(m + "," + n);
//
//                if(m == 0 && n == 0){
//                        if(obstacleGrid[0][0] == 0)
//                                return 1;
//                        else
//                                return 0;
//                }
//
//                if(m == 0){
//                        for(int i=0;i<=n;i++){
//                                if(obstacleGrid[0][i] == 1)
//                                        return 0;
//                        }
//                        return 1;
//                }
//                if(n == 0){
//                        for(int i=0;i<=m;i++){
//                                if(obstacleGrid[i][0] == 1)
//                                        return 0;
//                        }
//                        return 1;
//                }
//
//                dp = new int[m+1][n+1];
//
//                dp[1][0] = 1;
//                dp[0][1] = 1;
//
//                return pathfinder(m,n,obstacleGrid);
//        }
//
//        public static int magicNumber(int[] nums){
//
//
//
//                List<List<Integer>> result = new ArrayList<>();
//
//                int magic = -1;
//                int left = 0;
//                int right = nums.length-1;
//
//                while(left<right){
//                        int middle = (left+right)/2;
//                        if(nums[middle] == middle){
//                                magic = middle;
//                                return magic;
//                        }else if(nums[middle] > middle){
//                                right = middle;
//                        }else{
//                                left = middle;
//                        }
//                }
//
//                return magic;
//        }

//        public static int deleteAndEarn(int[] nums) {
//
//                if(nums == null || nums.length == 0)
//                        return 0;
//
//                used = new HashMap<Integer,Integer>();
//                dp = new int[nums.length][nums.length];
//
//                return helper(0,nums.length-1,nums);
//
//        }


        //static int[] dp;

//        static public int helper(int index, int amount, int[] coins){
//
//
//                if(amount == 0)
//                        return 0;
//
//                if(index < 0)
//                        return Integer.MAX_VALUE;
//
//                if(dp[index][amount] >0)
//                        return dp[index][amount];
//
//
//                if(amount-coins[index] >= 0){
//                        int val = helper(index,amount-coins[index],coins);
//                        if(val < Integer.MAX_VALUE){
//                                val = val + 1;
//                        }
//                        dp[index][amount] = Math.min(helper(index-1,amount,coins),val);
//                }
//                else{
//                        dp[index][amount] = helper(index-1,amount,coins);
//                }
//
//                return dp[index][amount];
//
//        }

//        static public int coinChange(int[] coins, int amount) {
//
//                if(amount == 0)
//                        return 0;
//
//                if(coins == null || coins.length == 0)
//                        return 0;
//
//                dp = new int[coins.length+1][amount+1];
//
//                int val = helper(coins.length-1,amount,coins);
//
//                if(val == Integer.MIN_VALUE)
//                        return -1;
//
//                return val;

//        }


//
//        public static int lengthOfRussianDoll(int index, int[][] envelopes){
//
//                if(index > envelopes.length-1)
//                        return 0;
//
//                if(dp[index] > 0)
//                        return dp[index];
//
//                int maxCount = 0;
//
//                for(int i=index+1;i<envelopes.length;i++){
//                        if(envelopes[index][1] > envelopes[i][1])
//                                maxCount = Math.max(maxCount, lengthOfRussianDoll(i,envelopes)+1);
//                }
//
//                dp[index] = maxCount;
//
//                return index;
//        }
//
//        public static int maxEnvelopes(int[][] envelopes) {
//
//
//
//                Arrays.sort(envelopes, new Comparator<int[]>() {
//                        @Override
//                        public int compare(int[] a1, int[] a2) {
//                                return a2[0] - a1[0];
//                        }
//                });
//
//
//                dp = new int[envelopes.length];
//
//                int maxCount = 0;
//                for(int i=0;i<envelopes.length;i++){
//                        maxCount = Math.max(maxCount, lengthOfRussianDoll(i,envelopes)+1);
//                }
//
//                return maxCount;
//
//        }

        public static int returnHeight(int i, int[][] graph){

                        int height = 0;

                        boolean[] visited = new boolean[graph.length];

                        Queue<Integer> q = new LinkedList<Integer>();

                        q.add(i);
                        visited[i] = true;

                        while(!q.isEmpty()){
                                List<Integer> hm = new ArrayList<Integer>();
                                while(!q.isEmpty()){
                                        hm.add(q.poll());
                                }
                                for(int k=0;k<hm.size();k++){
                                        int node = hm.get(k);
                                        int[] childs = graph[node];
                                        for(int j=0;j<childs.length;j++){
                                                if(childs[j] == 1 && !visited[j]){
                                                        q.add(j);
                                                        visited[j] = true;
                                                }
                                        }
                                }
                                height++;
                        }

                        return height;
                }
        public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

                int[][] graph = new int[n][n];

                int[] heights = new int[n];

                List<Integer> output = new ArrayList<Integer>();

                for(int[] edge:edges){
                        graph[edge[0]][edge[1]] = 1;
                        graph[edge[1]][edge[0]] = 1;
                }

                for(int i=0;i<n;i++){
                        heights[i] = returnHeight(i,graph);
                }

                int min = Integer.MAX_VALUE;
                for(int i=0;i<n;i++){
                        if(min > heights[i])
                                min = heights[i];
                }

                for(int i=0;i<n;i++){
                        if(heights[i] == min)
                                output.add(i);
                }

                return output;

        }

        public static int minMeetingRooms(int[][] intervals) {

                if(intervals == null || intervals.length == 0)
                        return 0;
                Arrays.sort(intervals, new Comparator<int[]>(){
                        @Override
                        public int compare(int[] a1, int[] a2){
                                if(a1[1] != a2[1])
                                        return a1[1] - a2[1];
                                else
                                        return a1[0] - a2[0];
                        }
                });

                int count = 0;

                int maxCount = 0;

                int min = Integer.MIN_VALUE;

                for(int[] interval:intervals){
                        int end = interval[1];
                        int start = interval[0];
                        if(start < min && min <= end){
                                count++;
                        }else{
                                min = end;
                                count = 1;
                        }
                        maxCount = Math.max(maxCount,count);
                }

                return maxCount;
        }

        public static int[][] merge(int[][] intervals) {

                Arrays.sort(intervals, new Comparator<int[]>(){
                        @Override
                        public int compare(int[] a1, int[] a2){
                                if(a1[0] != a2[0])
                                        return a1[0] - a2[0];
                                else
                                        return a1[1] - a2[1];
                        }
                });


                List<int[]> myList = new ArrayList<int[]>();

                int currEnd = intervals[0][1];
                int currStart = intervals[0][0];

                for(int[] interval:intervals){
                        int start = interval[0];
                        int end = interval[1];

                        if(start <= currEnd && currEnd <= end){
                                currEnd = end;
                        }else{
                                int[] arr = new int[2];
                                arr[0] = currStart;
                                arr[1] = currEnd;
                                myList.add(arr);
                                currStart = start;
                                currEnd = end;
                        }
                }

                int[] arr = new int[2];
                arr[0] = currStart;
                arr[1] = currEnd;
                myList.add(arr);

                int[][] output = new int[myList.size()][2];

                for(int i=0;i<myList.size();i++){
                        output[i] = myList.get(i);
                }

                return output;
        }

        public static int numTrees(int n) {

                int dp[] = new int[n+1];


                dp[0] = 1;
                dp[1] = 1;

                for(int i=2;i<=n;i++){
                        for(int j=i;j>=1;j--){
                                dp[i] += dp[i-j]*dp[j-1];
                        }
                }

                return dp[n];

        }

         public static class TreeNode {
 int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public static List<TreeNode> helper(int m, int n){
                List<TreeNode> myList = new ArrayList<TreeNode>();

                for(int k=m;k<=n;k++){

                        List<TreeNode> leftList = new ArrayList<TreeNode>();
                        List<TreeNode> rightList = new ArrayList<TreeNode>();

                        if(k-1 > 0){
                                leftList = helper(m,k-1);
                        }

                        if(k+1 <= n){
                                rightList = helper(k+1,n);
                        }

                        if(leftList.size() != 0 && rightList.size() != 0){
                                for(int i=0;i<leftList.size();i++){
                                        for(int j=0;j<rightList.size();j++){
                                                TreeNode root = new TreeNode(k);
                                                root.left = leftList.get(i);
                                                root.right = rightList.get(j);
                                                myList.add(root);
                                        }
                                }
                        }else if(leftList.size() != 0){
                                for(int j=0;j<leftList.size();j++){
                                        TreeNode root = new TreeNode(k);
                                        root.left = leftList.get(j);
                                        myList.add(root);
                                }
                        }else if(rightList.size() != 0){
                                for(int j=0;j<rightList.size();j++){
                                        TreeNode root = new TreeNode(k);
                                        root.right = rightList.get(j);
                                        myList.add(root);
                                }
                        }else{
                                TreeNode root = new TreeNode(k);
                                myList.add(root);
                        }

                }

                return myList;
        }
        public static List<TreeNode> generateTrees(int n) {

                List<TreeNode> myList =  helper(1,n);
                return myList;


        }

        public static int doTheMath(String c, int l, int r){

                if(c.equals("+")){
                        return l+r;
                }
                else if(c.equals("-")){
                        return l-r;
                }else{
                        return l*r;
                }
        }

        public static List<Integer> helper(int m, int n, List<String> s){
                List<Integer> myList = new ArrayList<Integer>();

                String all = "";
                for(int k=m;k<=n;k++){
                        if(s.get(k).equals("+") || s.get(k).equals("-") || s.get(k).equals("*")){

                                List<Integer> leftList = new ArrayList<Integer>();
                                List<Integer> rightList = new ArrayList<Integer>();

                                if(k-1 >= 0){
                                        leftList = helper(m,k-1,s);
                                }

                                if(k+1 <= n){
                                        rightList = helper(k+1,n,s);
                                }

                                if(leftList.size() != 0 && rightList.size() != 0){
                                        for(int i=0;i<leftList.size();i++){
                                                for(int j=0;j<rightList.size();j++){
                                                        int val = doTheMath(s.get(k),leftList.get(i),rightList.get(j));
                                                        myList.add(val);
                                                }
                                        }
                                }
                        }
                        if(m==n){
                                int val = Integer.parseInt (s.get(m));
                                myList.add(val);
                        }


                }

                return myList;
        }

        public static List<Integer> diffWaysToCompute(String s) {

                List<String> input = new ArrayList<String>();

                String all = "";
                for(int i=0;i<s.length();i++) {
                        if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') {
                                input.add(all);
                                input.add(String.valueOf(s.charAt(i)));
                                all = "";
                        }else{
                                all += s.charAt(i);
                        }
                }

                if(all != ""){
                        input.add(all);
                }
                return helper(0,input.size()-1,input);
        }

        static int[][] dp;

        public static int giveLeft(boolean[] busted,int k,int[] nums){

                for(int i=k-1;i>=0;i--){
                        if(!busted[i])
                                return nums[i];
                }
                return 1;
        }

        public static int giveRight(boolean[] busted,int k,int[] nums){

                for(int i=k+1;i<nums.length;i++){
                        if(!busted[i])
                                return nums[i];
                }
                return 1;
        }

        public static int burst(int i, int j, int[] nums, boolean[] busted){

                if(i>j)
                        return 0;

                if(dp[i][j] > 0)
                        return dp[i][j];

                dp[i][j] = 0;
                for(int k=i;k<=j;k++){
                        busted[k] = true;
                        dp[i][j] = Math.max(dp[i][j],burst(i,k-1,nums,busted) + burst(k+1,j,nums,busted)
                                + giveLeft(busted,k,nums)*nums[k]*giveRight(busted,k,nums));
                        busted[k] = false;
                }

                return dp[i][j];
        }


        public static int helper(List<Integer> stones){

                if(stones.size() == 0)
                        return 0;

                if(stones.size() == 1)
                        return stones.get(0);

                int min = 0;
                for(int i=0;i<stones.size();i++){
                        for(int j =i+1;j<stones.size();j++){
                                int val = 0;
                                if(stones.get(i) <= stones.get(j) ){
                                        if(stones.get(i)  == stones.get(j)){
                                                List<Integer> newList = stones;
                                                newList.remove(i);
                                                newList.remove(j);
                                                val = helper(newList);
                                        }else{
                                                List<Integer> newList = stones;
                                                int item = stones.get(j)  - stones.get(i);
                                                newList.remove(i);
                                                newList.remove(j);
                                                newList.add(item);

                                                val = helper(newList);
                                        }
                                }
                                min = Math.min(min,val);
                        }
                }

                return min;

        }


        public static String consCount(String input){

                if(input == null || input.length() == 0)
                        return "";

                int curr = Character.getNumericValue(input.charAt(0));

                int count = 1;
                String output = "";
                for (int i=1;i<input.length();i++){
                        if(Character.getNumericValue(input.charAt(i)) == curr)
                                count++;
                        else{
                                output += String.valueOf(count) + String.valueOf(curr);
                                count = 1;
                                curr = Character.getNumericValue(input.charAt(i));
                        }
                }

                output += String.valueOf(count) + String.valueOf(curr);

                return output;

        }

        public static int lastStoneWeightII(int[] stones) {

                List<Integer> myList = new ArrayList<Integer>();

                for(int i=0;i<stones.length;i++){
                        myList.add(stones[i]);
                }

                return helper(myList);
        }

        static int[] men;

        public static int helper(int l, int[] cost, int[] len){

                if(l <= 0){
                        return 0;
                }

                if(men[l] > 0)
                        return men[l];

                men[l] = 0;
                for(int i=0;i<len.length;i++){
                        if(l-len[i] >=0){
                                men[l] = Math.max(men[l],helper(l-len[i],cost,len) + cost[i]);
                        }
                }

                return men[l];
        }

        public static int maxCost(int length){

                int[] len = {1,2,3,4,5,6,7,8};
                int[] cost = {1,5,8,9,10,17,17,20};

                men = new int[length+1];


                return helper(length,cost,len);

        }

        public static String patternMatch(String input){

                if(input == null)
                        return "";

                int diff = 32;

                Stack<Character> s = new Stack<Character>();

                for(int i=0;i<input.length();i++){
                        if(!s.isEmpty() && Math.abs(input.charAt(i) - s.peek()) == diff){
                                s.pop();
                        }else{
                                s.push(input.charAt(i));
                        }
                }

                String output = "";

                while(!s.isEmpty()){
                        output = String.valueOf(s.pop()) + output ;
                }

                return output;
        }

        public static boolean canConstruct(String ransomNote, String magazine) {
                int[] arr = new int[26];

                for(int i=0;i<ransomNote.length();i++){
                        arr[ransomNote.charAt(i)-97]++;
                }

                for(int i=0;i<magazine.length();i++){
                        if(arr[magazine.charAt(i)-97] > 0)
                                arr[magazine.charAt(i)-97]--;
                }

                for(int i=0;i<arr.length;i++){
                        if(arr[i] > 0)
                                return false;
                }

                return true;
        }

        public static boolean isPalindrom(String s1, String s2){

                int p1 = 0;
                int p2 = s1.length()-1;

                int p3 = 0;
                int p4 = s2.length()-1;

                while(p1<s1.length() && p4>=0){

                        if(p1 == p4)
                                return true;
                        if(s1.charAt(p1) == s2.charAt(p4)){
                                p1++;
                                p4--;
                        }else{
                                break;
                        }
                }

                while(p3<s2.length() && p2>=0){

                        if(p2 == p3)
                                return true;
                        if(s1.charAt(p2) == s2.charAt(p3)){
                                p3++;
                                p2--;
                        }else{
                                break;
                        }
                }

                return false;
        }

        public static String smallestSubsequence(String text) {

                Deque<Character> s = new LinkedList<Character>();


                int[] count = new int[26];

                for(int i=0;i<text.length();i++){
                        count[text.charAt(i)-97]++;
                }

                boolean[] visited = new boolean[26];

                for(int i=0;i<text.length();i++){

                        char c = text.charAt(i);

                        if(!visited[c-97]){
                                while(!s.isEmpty() && s.peek() > c && count[s.peek()-97] > 0){
                                        visited[s.peek()-97] = false;
                                        s.pop();
                                }

                                s.push(c);
                                visited[c-97] = true;
                        }
                        count[text.charAt(i)-97]--;
                }

                String out = "";

                while(!s.isEmpty()){
                        out = s.pop() + out;
                }

                return out;
        }



        public static TreeNode increasingBST(TreeNode root) {
                return helper(root);
        }

        public static TreeNode helper(TreeNode node){

                List<List<String>> list = new ArrayList<>();

                TreeNode curr = node;
                System.out.println(node.val);
                if(node.right == null && node.left == null)
                        return node;

                if(node.right != null){
                        node.right = helper(node.right);
                }
                if(node.left != null){
                        curr = helper(node.left);
                        TreeNode next = curr;
                        while(next.right != null){
                                next = next.right;
                        }
                        next.right = node;
                }
                return curr;
        }

        public static String[] permute(String S) {


                List<List<String>> list = new ArrayList<>();

                int index = 0;
                List<String> curr = new ArrayList<String>();
                String str = "";
                for(int i=0;i<S.length();i++){
                        if(S.charAt(i) == '{'){
                                if(str.length() > 0){
                                        curr.add(str);
                                        list.add(curr);
                                        curr = new ArrayList<String>();
                                        str = "";
                                }
                                i++;
                                while(S.charAt(i) != '}'){
                                        if(S.charAt(i) == ','){
                                                i++;
                                        }else{
                                                curr.add(String.valueOf(S.charAt(i)));
                                                i++;
                                        }
                                }
                                list.add(curr);
                                curr = new ArrayList<String>();
                        }else if(S.charAt(i) == ','){
                                continue;
                        }else{
                                str = str + S.charAt(i);
                        }
                }

                if(str.length() > 0){
                        curr.add(str);
                        list.add(curr);
                }


                List<String> out = new ArrayList<String>();

                out.add("");

                for(int i=0;i<list.size();i++){
                        List<String> newl = new ArrayList<String>();
                        for(int k=0;k<out.size();k++){
                                String st = out.get(k);
                                List<String> l = list.get(i);
                                for(int j=0;j<l.size();j++){
                                        newl.add(st + l.get(j));
                                }
                        }
                        out = newl;
                }

                String[] arr = new String[out.size()];

                int i=0;
                for(String s:out){
                        arr[i] = s;
                        i++;
                }
                return arr;
        }

        public static HashMap<Integer,Boolean> brain = new HashMap<Integer,Boolean>();

        public static boolean rotateCheck(int N, HashMap<Integer,Integer> map){
                int inital = N;
                String s = "";
                int d = 10;
                int val = -1;
                while(N>0){
                        int q = N/d;
                        int r = N%d;
                        if(brain.containsKey(q)){
                                return true;
                        }
                        if(map.containsKey(r)){
                                s = s+ map.get(r);
                        }else{
                                brain.put(inital,false);
                                return false;
                        }
                        N = q;
                }

                val = Integer.valueOf(s);
                if(inital != val){
                        brain.put(inital,true);
                       return true;
                }
                else {
                        return false;
                }
        }
        public static int confusingNumberII(int N) {

                HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
                map.put(1,1);
                map.put(6,9);
                map.put(0,0);
                map.put(9,6);
                map.put(8,8);
                int count = 0;
                List<Integer> list = new ArrayList<Integer>();
                for(int i=1;i<=N;i++){
                        if(rotateCheck(i,map)){
                                list.add(i);
                                count++;
                        }

                }

                return count;
        }

        public static class MyException extends Exception{

                public MyException(){
                        System.out.println("user not found");
                }
        }

        public static class MyException2 extends Exception{

                public MyException2(){
                        System.out.println("user 2 not found");
                }
        }


        static HashMap<String,Integer> map = new HashMap<String,Integer>();

        public static int helper(int[] values, boolean[] visited, int[] labels, int num_wanted, int use_limit,int len,int[] count) throws MyException, MyException2{

                if(len > num_wanted)
                        return 0;

                String state = Arrays.toString(visited);

                if(map.containsKey(state))
                        return map.get(state);

                int max = 0;

                for(int i = 0;i<values.length;i++){
                        if(!visited[i] && count[labels[i]] > 0){
                                visited[i] = true;
                                count[labels[i]]--;
                                max = Math.max(max, helper(values,visited,labels,num_wanted,use_limit,len+1,count));
                                visited[i] = false;
                                count[labels[i]]++;
                        }
                }

                map.put(state,max);

                return max;
        }


//        public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
//
//                int high = 0;
//                for(int i=0;i<labels.length;i++){
//                        if(labels[i] > high)
//                                high = labels[i];
//                }
//                int[] count = new int[high+1];
//
//                boolean[] visited = new boolean[values.length];
//
//                for(int i=0;i<labels.length;i++){
//                        if(count[labels[i]] + 1 <= use_limit)
//                                count[labels[i]]++;
//                }
//
//                        int max = 0;
//
//                        for(int i = 0;i<values.length;i++){
//                                if(!visited[i] && count[labels[i]] > 0){
//                                        visited[i] = true;
//                                        count[labels[i]]--;
//                                        max = Math.max(max, values[i] + helper(values,visited,labels,num_wanted,use_limit,1,count));
//                                        visited[i] = false;
//                                        count[labels[i]]++;
//                                }
//                        }
//
//
//
//
//
//                return max;
//        }

//        public static void sortOddEven(int[] list){
//
//                Arrays.sort(list,new Comparator<Integer>(){
//                        @Override
//                        public int compare(Integer lhs,Integer rhs) {
//
//
//
//                                String[] arrlhs = lhs.split(" ",2);
//                                String[] arrrhs = rhs.split(" ",2);
//                                if(arrlhs[1].equals(arrrhs[1])){
//                                        return arrlhs[0].compareTo(arrrhs[0]);
//                                }else{
//                                        return arrlhs[1].compareTo(arrrhs[1]);
//                                }
//                        }
//                });
//        }

//        public List<String> invalidTransactions(String[] transactions) {
//                HashMap<String,HashMap<String,List<String[]>>> myMap = new HashMap<String,HashMap<String, List<String[]>>>();
//
//                for(String trans:transactions){
//                        String[] arr = trans.split(",");
//                        if(Integer.valueOf(arr[2]) > 1000){
//                                continue;
//                        }else{
//                                if(myMap.containsKey(arr[0])){
//                                        if(myMap.get(arr[0]).containsKey(arr[3])){
//                                                List<String[]> myList= myMap.get(arr[0]).get(arr[3]);
//                                                myList.add(arr);
//                                        }else{
//                                                List<String[]> myList = new ArrayList<String[]>();
//                                                myList.add(arr);
//                                                myMap.get(arr[0]).put(arr[3],myList);
//                                        }
//                                }else{
//                                        HashMap<String,List<String[]>> tempMap = new HashMap<String,List<String[]>>();
//                                        List<String[]> myList = new ArrayList<String[]>();
//                                        myList.add(arr);
//                                        tempMap.put(arr[3],myList);
//                                        myMap.put(arr[0],tempMap);
//                                }
//                        }
//                }
//
//                for(String e : myMap.keySet()){
//
//                }
//        }


        public static void main(String[] args){

                        List<String> returnList = new ArrayList<String>();

                Collections.sort(returnList, new Comparator<String>(){
                        @Override
                        public int compare(String s1, String s2){
                                String[] s1_arr = s1.split(":");
                                String[] s2_arr = s2.split(":");
                                if(s1_arr[1].equals("start") && s2_arr[1].equals("start")){
                                        return s1_arr[2].compareTo(s2_arr[2]);
                                }else if(s1_arr[1].equals("start") && s2_arr[1].equals("end")){
                                        return 1;
                                }else if(s1_arr[1].equals("end") && s2_arr[1].equals("start")){
                                        return -1;
                                }else{
                                        return s2_arr[2].compareTo(s1_arr[2]);
                                }
                        }
                });
//                        returnList.add("236 cat dog rabbit snake");
//                        returnList.add("ykc 82 01");
//                        returnList.add("eo first qpx");
//                        returnList.add("az0 first qpx");
//                        returnList.add("09z cat hamster");
//                        returnList.add("06f 12 25 6");

//
//                        returnList.add("t2 12 121 98");
//                        returnList.add("r1 box ape bit");
//                        returnList.add("b4 xi me nu");
//                        returnList.add("br8 eat nim did");
//                        returnList.add("w1 has uni gry");
//                        returnList.add("f3 52 54 31");

//                        returnList.add("mi2 jog mid pet");
//                        returnList.add("wz3 34 54 398");
//                        returnList.add("a1 alps cow bar");
//                        returnList.add("x4 45 21 7");


                        //int[] cost = {3,3,3,4,2};

                        String[] arr = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;

        int[][] cost = {{0}};

                        int amount = 4;


                        int q = 6; int[][] edges = {{1,3},{2,6},{8,10},{15,18}};


                        int[] input = {2,7,4,1,8,1};



                        String my = "2-1-1";


                        int[] values = {5,4,3,2,1};
                        int[] lables = {1,3,3,3,2};

                        //System.out.println(largestValsFromLabels(values,lables,3,2));

//                        TreeNode node = new TreeNode(5);
//                TreeNode node1 = new TreeNode(3);
//                TreeNode node2 = new TreeNode(6);
//                node.right = node2;
//                node.left = node1;
//
//                increasingBST(node);

                }

}
