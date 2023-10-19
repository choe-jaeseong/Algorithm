import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        HashSet<Integer> owned = new HashSet<>();
        
        // Logic
        for(int i=1;i<=q;i++){
            int nowGoal = Integer.parseInt(br.readLine());
            int blockedNum = 0;
            for(int tmp=nowGoal;tmp>=2;tmp/=2) if(owned.contains(tmp)) blockedNum = tmp;
            // Output
            System.out.println(blockedNum);
            // for next
            if(blockedNum==0) owned.add(nowGoal);
        }
    }
}

/*
1. 원하는 땅에서부터 1까지 탐색.
2. 1까지 가는 중간에 땅을 가진 자가 있다면 stack 에 쌓기
3. 스택이 비어있다면, 소유 가능. 0 출력
    스택이 차있다면, 소유 불가능. stack.peek 출력
 */