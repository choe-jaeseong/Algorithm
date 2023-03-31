package Greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//4. 최대 수입 스케쥴(PriorityQueue 응용문제)
class Request implements Comparable<Request>{
    int m, d;
    public Request(int m, int d){
        this.m = m;
        this.d = d;
    }
    @Override
    public int compareTo(Request o){
        return o.d-this.d; //deadline 내림차순
    }
}
public class GREEDY_04 {
    static int n, max = Integer.MIN_VALUE;
    public int Solution(ArrayList<Request> arr){
        int income=0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j = 0;
        for(int i=max; i>=1; i--){
            for( ; j<n; j++){
                if(arr.get(j).d<i) break;
                pQ.offer(arr.get(j).m);
            }
            if(!pQ.isEmpty()) income+=pQ.poll();
        }
        return income;
    }
    public static void main(String[] args) {
        GREEDY_04 T = new GREEDY_04();
        Scanner sc = new Scanner(System.in);
        ArrayList<Request> arr = new ArrayList<>();
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            int m = sc.nextInt(); //money
            int d = sc.nextInt(); //deadline
            arr.add(new Request(m, d));
            if(d>max) max = d;
        }
        System.out.println(T.Solution(arr));
        sc.close();
    }
}
