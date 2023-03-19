package DFS_BFS;
public class DFS_01 {

    public void DFS(int n){
        if(n==0) return ;
        else {
            DFS(n-1);
            System.out.println(n + " ");
        }
    }
    
    public static void main(String[] args) {
        DFS_01 T = new DFS_01();
        T.DFS(5);
    }
}
