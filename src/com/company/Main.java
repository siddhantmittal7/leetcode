package com.company;

import java.math.BigInteger;
import java.util.*;

public class Main {


      //Definition for singly-linked list.
//      static public class ListNode {
//          int val;
//          ListNode next;
//          ListNode(int x) { val = x; }
//      }
//
//
//   static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//          int mult = 1;
//          BigInteger num1 = BigInteger.valueOf(l1.val*mult);
//        while(l1.next != null){
//            l1 = l1.next;
//            mult = mult*10;
//            num1 = num1.add(BigInteger.valueOf(l1.val*mult));
//        }
//
//        mult = 1;
//       BigInteger num2 = BigInteger.valueOf(l2.val*mult);
//        while(l2.next != null){
//            l2 = l2.next;
//            mult = mult*10;
//            num2 = num2.add(BigInteger.valueOf(l2.val*mult));
//        }
//
//       BigInteger add = num1.add(num2);
//
//        ListNode l3;
//
//        long dig = add%10;
//        long rem = add/10;
//
//        ListNode n = new ListNode((int)dig);
//
//        ListNode result = n;
//
//        add = rem;
//
//        while(add != 0){
//            dig = add%10;
//            rem = add/10;
//
//            add = rem;
//
//            ListNode n_new = new ListNode((int)dig);
//
//            n.next = n_new;
//
//            n = n_new;
//        }
//
//        return result;
//    }

//    static void printNew(ListNode n){
//        System.out.print(n.val + "->");
//          while(n.next != null){
//              n = n.next;
//              System.out.print(n.val + "->");
//
//          }
//    }

    static public String addStrings(String num1, String num2) {

        int num1Length = num1.length();
        int num2Length = num2.length();

        int[] sum;

        if(num1Length > num2Length){
            sum = new int[num1Length+1];
            for(int i=0;i<num1Length-num2Length;i++){
                num2 = "0" + num2;
            }
        }else{
            sum = new int[num2Length+1];
            for(int i=0;i<num2Length-num1Length;i++){
                num1 = "0" + num1;
            }
        }

        for(int i=num2.length()-1;i>=0;i--){
            int value = (num1.charAt(i)-'0') + (num2.charAt(i)-'0');
            sum[i+1] = sum[i+1] + value;

            int val = sum[i+1];

            if(val>9){
                sum[i+1] = val%10;
                sum[i] = val/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;
        if(sum.length>1){

            for(int i=0; i<sum.length;i++){
                if(sum[i] != 0 || i+1>=sum.length)
                    break;
                start++;
            }
        }

        for(int i=start;i<sum.length;i++){
            sb.append(sum[i]);
        }

        return sb.toString();
    }

    static public int lengthOfLongestSubstring(String s) {
        //List<Character> listOfchar = new ArrayList<Character>();

        String listOfchar = "";

        int maxlen = 0;
        for(int i=0;i<s.length();i++){
            if(listOfchar.contains(String.valueOf(s.charAt(i)))){
                int j = listOfchar.indexOf(s.charAt(i));
                listOfchar = listOfchar.substring(j+1) + String.valueOf(s.charAt(i));
            }else {
                listOfchar = listOfchar + String.valueOf(s.charAt(i));
            }
            if(listOfchar.length() > maxlen){
                maxlen = listOfchar.length();
            }

        }
        return maxlen;
    }

    static public String multiply(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int[] arr = new int[num1.length() + num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int val = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                arr[i+j+1] = arr[i+j+1] + val;
                int nVal = arr[i+j+1];
                if(nVal > 9){
                    arr[i+j+1] = nVal%10;
                    arr[i+j] = arr[i+j] + nVal/10;
                }
            }
        }

        int start = 0;
        if(arr.length>1){

            for(int i=0; i<arr.length;i++){
                if(arr[i] != 0 || i+1>=arr.length)
                    break;
                start++;
            }
        }

        for(int i=start;i<arr.length;i++){
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    //non-decreasing order
    static int[] insertionSort(int[] a){


        for(int i=1;i<a.length;i++){
            int j=i;
            int temp = a[j];
            while(j>0 && temp < a[j-1]){
                    a[j] = a[j-1];
                    j--;
            }
            a[j] =temp;

        }

        return a;
    }

    //non-increasing order
    static int[] insertionSort_2(int[] a){


        for(int i=a.length-2;i>=0;i--) {
            int j = i;
            while (j < a.length - 1 && a[j] < a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
                j++;
            }
        }
        return a;
    }

    //2 n-bit numbers sum
    static int[] addBitNumbers(int[] a, int[] b){
        int[] c = new int[a.length + 1];

        int carry = 0;
        for(int i=a.length-1;i>=0;i--){
            c[i+1] =  (a[i] + b[i] + carry)%2;
            if(((a[i] + b[i] + carry)) >= 2){
                carry = 1;
            }else{
                carry = 0;
            }
        }
        c[0] = carry;

        return c;
    }

    static void printArray(int[] a){
        for (int i =0;i<a.length;i++){
            if(i<a.length -1)
                System.out.print(a[i] + ",");
            else
                System.out.print(a[i]);
        }
        System.out.print('\n');
    }

    static void printArray(List<String> a){
        for (int i =0;i<a.size();i++){
            if(i<a.size() -1)
                System.out.print(a.get(i) + ",");
            else
                System.out.print(a.get(i));
        }
        System.out.print('\n');
    }

    //rotated sorted array
    static int findMin(int[] a){

        if(a.length == 1)
            return a[0];

        if(a[0]<a[a.length-1])
            return a[0];


        int mid;

        if(a.length%2 == 0){
            mid = (int) Math.floor(a.length/2-1);
        }else{
            mid = (int) Math.floor(a.length/2);
        }

        if(mid-1 >= 0 && a[mid] < a[mid-1])
            return a[mid];
        else if(mid+1 <a.length && a[mid] > a[mid+1] )
            return a[mid+1];
        else{
            if(a[mid] > a[0])
                return findMin(Arrays.copyOfRange(a,mid+1,a.length));
            else
                 return findMin(Arrays.copyOfRange(a,0,mid));
        }
    }

    static class Pair {
        Character key;
        int value;

        public Pair(Character key, int value) {
            this.key = key;
            this.value = value;
        }
    }

//    //K frequent elements
//    static List<String> topKFrequent(String[] words, int k) {
//
//        List<String> result = new ArrayList<String>();
//        Map<String, Integer> numMap = new TreeMap<String,Integer>();
//
//        for(int i=0; i<words.length;i++){
//            if(numMap.containsKey(words[i])){
//                int value = numMap.get(words[i]) + 1;
//                numMap.replace(words[i],value);
//            }else{
//                numMap.put(words[i],1);
//            }
//        }
//
//        Iterator it = numMap.entrySet().iterator();
//
//
//        List<Pair> listPair = new ArrayList<Pair>();
//
//        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                if(o2.value == o1.value)
//                    return o1.key.compareTo(o2.key);
//                else
//                    return o2.value - o1.value;
//            }
//        });
//
//        while(it.hasNext()){
//            Map.Entry m = (Map.Entry)it.next();
//            Pair p = new Pair((String)m.getKey(),(int)m.getValue());
//            pq.add(p);
//        }
//
//        while(pq.size() > 0 && k > 0){
//            result.add(pq.poll().key);
//            k--;
//        }
//
//        return result;
//
//    }

    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        int result = 0;

        while(pq.size() > 0 && k>0){

            result = pq.poll();
            k--;
        }

        return result;
    }

    static int[] selectionSort(int[] a){

        int j = 0;
        int index = 0;
        while(j<a.length-1){
            int min = a[j];
            index = j;
            for(int i=j+1;i<a.length;i++){
                if(a[i] < min){
                    min = a[i];
                    index = i;
                }
            }
            int temp = a[j];
            a[j] = min;
            a[index] = temp;
            j++;
        }

        return a;
    }

    static String frequencySort(String s) {

        Map<Character,Integer> charMap = new HashMap<Character, Integer>();

        for(Character c : s.toCharArray()){
            if(charMap.containsKey(c)){
                int value = charMap.get(c) + 1;
                charMap.replace(c,value);
            }else{
                charMap.put(c,1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                        return b.getValue() - a.getValue();
                    }
                }
        );
        pq.addAll(charMap.entrySet());

        String result = "";
        while(pq.size() > 0){
            Map.Entry p = pq.poll();
            for(int i=0;i<(int)p.getValue();i++)
                result = result + p.getKey();
        }

        return result;
    }


    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length;
        int sumLength = 0;
        if(count%2 != 0){
            sumLength = count/2 + 1;
        }else{
            sumLength = count/2;
        }

        int i = 0; int j = 0; int k = 0;

        int[] combSort = new int[sumLength];

        while(k<sumLength && i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                combSort[k] = nums1[i];
                k++;
                i++;
            }else{
                combSort[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(k<sumLength && i < nums1.length){
            combSort[k] = nums1[i];
            k++;
            i++;
        }

        while(k<sumLength && j < nums2.length){
            combSort[k] = nums2[j];
            k++;
            j++;
        }

        if(count%2 == 0){
            double mSum = combSort[k-1];
            if(i < nums1.length && j < nums2.length){
                if(nums1[i] < nums2[j]){
                    mSum = mSum + nums1[i];
                }else{
                    mSum = mSum + nums2[j];
                }
            }else if(i < nums1.length){
                mSum = mSum + nums1[i];
            }else if(j < nums2.length){
                mSum = mSum + nums2[j];
            }
            return mSum/2;

        }else{
           return combSort[k-1];
        }
    }

    static public int guess(int n){
        if(n<1702766719)
            return 1;
        if(n==1702766719)
            return 0;
        if(n>1702766719)
            return -1;
        return 0;
    }

    static public int keepGuessing(int n, int k){

        if(n-k == 0)
            return n;
        Random rand = new Random();
        int value = rand.nextInt(n) + k;

        if(guess(value) == 0)
            return value;
        else if(guess(value) == -1)
            return keepGuessing(value,k);
        else if(guess(value) == 1)
            return keepGuessing(n,value);
        return 0;
    }

    static public int guessNumber(int n) {
        return keepGuessing(n,1);
    }

    public static void main(String[] args) {
	// write your code here


        //System.out.print("JDK installed");

        /*
        Sorting test
            int[] inputArray = {8,3,5,6,11,45,2,1,6,9};
            int[] outputArray = insertionSort(inputArray);
            printArray(outputArray);
         */

        /*
        int[] a = {1,1,0};
        int[] b = {1,0,1};

        printArray(addBitNumbers(a,b));
         */

        //int[] a = {1,2,3};

        //System.out.print(findMin(a));

        //printArray(topKFrequent(a,3));

        //System.out.print(frequencySort("tree"));

        String s = "dvdf";

        //int[] a = {3};
        //int[] b = {-2,-1};


        //System.out.print(guessNumber(2126753390));

        int[] a = {1,2,3,8,9,3,5};

        printArray(selectionSort(a));
    }
}




