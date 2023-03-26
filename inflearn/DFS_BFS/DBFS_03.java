package DFS_BFS;
import java.util.Scanner;

// 3. 최대점수 구하기(DFS)
public class DBFS_03 {
    static int n, m, ans=Integer.MIN_VALUE;
    public void DFS(int L, int score, int taken_time, int[][] arr){
        if(taken_time>m) return;
        if(L==n){
            ans=Math.max(ans, score);
        }
        else {
            DFS(L+1, score+arr[L][0], taken_time+arr[L][1], arr);
            DFS(L+1, score, taken_time, arr);
        }
    }

    public static void main(String[] args) {
        DBFS_03 T = new DBFS_03();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i][0] = sc.nextInt(); //문제의 점수
            arr[i][1] = sc.nextInt(); //문제의 소요시간
        }    
        T.DFS(0, 0, 0, arr);
        System.out.println(ans);
        sc.close();
    }
}

//나의 풀이
/*
 * public class practice {
    static int n, timeLimit, max_score=0;
    static int[][] problems; 
    public void DFS(int L, int score, int time){
        if(time>timeLimit) return;
        if(L==n){
            max_score = Math.max(max_score, score);
        } else {
            DFS(L+1, score+problems[L][0], time+problems[L][1]);
            DFS(L+1, score, time);
        }
    }
    public static void main(String[] args) {
        practice T = new practice();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        timeLimit = sc.nextInt();
        problems = new int[n][2];
        for(int i=0; i<n; i++){
            problems[i][0] = sc.nextInt(); //점수
            problems[i][1] = sc.nextInt(); //시간
        }
        T.DFS(0, 0, 0);
        System.out.println(max_score);
        sc.close();
    }
}
 */