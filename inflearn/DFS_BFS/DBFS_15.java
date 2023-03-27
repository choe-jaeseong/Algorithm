package DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;


//15. 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)
/*
 * 1. m개의 피자집 조합을 만들어서, 그 때의 도시의 피자거리의 합을 구한다.
 * 2. 각 조합마다 계산된 피자거리 합 중 최소값을 구하자
 */
class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class DBFS_15 {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> hs, pz;
    public void DFS(int L, int s){
        if(L==m){
            int sum=0;
            for(Point h : hs){
                int dis = Integer.MAX_VALUE;
                for(int i : combi){ //각 집의 피자거리 합
                    dis=Math.min(dis, Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y));
                }
                sum+=dis; //도시의 피자거리합
            }
            answer=Math.min(answer, sum);
        }
        else {
            for(int i=s; i<len; i++){   //조합(외워두기)
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        DBFS_15 T = new DBFS_15();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pz= new ArrayList<>();
        hs= new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp=sc.nextInt();
                if(tmp==1) hs.add(new Point(i, j));
                else if(tmp==2) pz.add(new Point(i, j));
            }
        }
        len=pz.size();
        combi=new int[m];
        T.DFS(0,0);
        System.out.println(answer);
        sc.close();
    }
}
