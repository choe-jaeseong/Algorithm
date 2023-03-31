package Greedy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//3. 결혼식
//나의 답
// public class GREEDY_03 {
//     static int[] time = new int[73];
//     static int max = 0;
//     public static void main(String[] args) {
//         GREEDY_03 T = new GREEDY_03();
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         for(int i=0; i<n; i++){
//             int s = sc.nextInt();
//             int e = sc.nextInt();
//             for(int j=s; j<e; j++){
//                 time[j]++;
//                 if(time[j]>max) max = time[j];
//             }
//         }
//         System.out.println(max);
//         sc.close();
//     }
// }

//강의 답
class Time implements Comparable<Time>{
    public int time;
    public char state;
    Time(int time, char state){
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Time ob){  //시간 순서로 먼저 정렬. 시간이 같다면 end point를 먼저 추가.
        if(this.time==ob.time) return this.state-ob.state; //오름차순
        else return this.time-ob.time; //오름차순
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
            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }
        System.out.println(T.solution(arr));
        sc.close();
    }
}
