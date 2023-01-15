public class DFS_02 {

    public void DFS(int n){
        if(n==0) return ;
        else {
            DFS(n/2);
            System.out.print(n%2);
        }
    }
    
    public static void main(String[] args) {
        DFS_02 T = new DFS_02();
        T.DFS(10);
    }
}
