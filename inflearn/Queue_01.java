// 5-6. 공주 구하기
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_01 {

    public int solution(int n, int k){
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) q.offer(i);
        while(!q.isEmpty()){
            for(int i=1; i<k; i++) q.offer(q.poll());
            q.poll();
            if(q.size()==1) ans = q.poll();
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Queue_01 T = new Queue_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(T.solution(n,k));
        sc.close();
    }
}
