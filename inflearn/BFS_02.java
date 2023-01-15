import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BFS_02 {
    int ans = 0;
    int[] ch;
    int[] dis = {1, -1, 5};
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int h, int s){
        ch = new int[10001];
        ch[h]=1;
        Q.offer(h);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x = Q.poll();
                for(int j=0; j<3; j++){
                    int nx = x + dis[j];
                    if(nx==s) return L + 1;
                    if(nx>0 && nx<10001 && ch[nx]==0){
                        Q.offer(nx);
                        ch[nx]=1;
                    }
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        BFS_02 T = new BFS_02();
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int s = sc.nextInt();
        System.out.println(T.BFS(h, s));
    }
}
