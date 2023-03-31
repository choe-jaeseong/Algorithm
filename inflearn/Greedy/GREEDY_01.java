package Greedy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//1. 씨름선수
class Body implements Comparable<Body>{
    public int h, w;
    Body(int h, int w){
        this.h=h;
        this.w=w;
    }
    @Override
    public int compareTo(Body o){
        return o.h-this.h;  //내림차순
    }
}

public class GREEDY_01 {
    public int solution(ArrayList<Body> arr, int n){
        int cnt = 0;
        Collections.sort(arr);
        int max=Integer.MIN_VALUE;
        for(Body ob : arr){
            if(ob.w>max){
                max=ob.w;
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        GREEDY_01 T = new GREEDY_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int h=sc.nextInt();
            int w=sc.nextInt();
            arr.add(new Body(h,w));
        }
        System.out.println(T.solution(arr,n));
        sc.close();
    }
}



// 나의 답
// import java.util.Scanner;

// public class GREEDY_01 {
//     public int solution(int n, int[][] arr){
//         int cnt = 0, ans = 0;
//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 if(i==j) continue;
//                 if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) break;
//                 else cnt++;
//                 if(cnt==n-1) ans++;
//             }
//             cnt=0;
//         }
//         return ans;
//     }
//     public static void main(String[] args) {
//         GREEDY_01 T = new GREEDY_01();
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[][] arr = new int[n][2];
//         for(int i=0; i<n; i++){
//             for(int j=0; j<2; j++){
//                 arr[i][j] = sc.nextInt();
//             }
//         }
//         System.out.println(T.solution(n, arr));;
//         sc.close();
//     }
// }
