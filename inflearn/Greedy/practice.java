package Greedy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    int s, e;
    public Time(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Time o){ //e로 기준을 두어야, 이용가능한 최대개수를 구할 수 있음.
        if(this.e==o.e) return this.s-o.s;
        else return this.e-o.e;
    }
}
public class practice {
    public int solution(int n, ArrayList<Time> arr){
        int answer = 0;
        Collections.sort(arr);
        int end=0;
        for(Time o : arr){
            if(end <= o.s){
                answer++;
                end = o.e;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        practice T = new practice();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.add(new Time(a,b));
        }
        System.out.println(T.solution(n, arr));
        sc.close();
    }
}
