package Greedy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    public int time;
    public char state;
    Time(int time, char state){
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Time ob){
        if(this.time==ob.time) return this.state-ob.state;
        else return this.time-ob.time;
    }
}

public class GREEDY_03 {
    public int solution(ArrayList<Time> arr){
        int ans = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for(Time ob : arr){
            if(ob.state=='s') cnt++;
            else cnt--;
            ans=Math.max(ans, cnt);
        }
        return ans;
    }
    public static void main(String[] args) {
        GREEDY_03 T = new GREEDY_03();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int sT = sc.nextInt();
            int eT = sc.nextInt();
            System.out.println("HI");
            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }
        System.out.println(T.solution(arr));
        sc.close();
    }
}
