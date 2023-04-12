package DFS_BFS;
public class DFS_06 {
    static int n;
    static int[] check; //해당하는 부분을 체크
    public void DFS(int L){
        if(L==n+1){
            String tmp="";
            for(int i=1; i<=n; i++){
                if(check[i]==1) tmp+=(i+" "); //check된 부분만 출력
            }
            if(tmp.length()>0) System.out.println(tmp);
        }
        else {
            check[L]=1; //check O
            DFS(L+1);   //다음 층으로 진행
            check[L]=0; //check X
            DFS(L+1);   //다음 층으로 진행
        }
    }
    
    public static void main(String[] args) {
        DFS_06 T = new DFS_06();
        n = 3;
        check=new int[n+1]; //각 숫자를 그대로 쓰기 위해서 n+1;
        T.DFS(1);
    }
}
