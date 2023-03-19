package DFS_BFS;
import java.util.Scanner;

public class DBFS_06 {
  static int n, m;
  static int[] pm, arr, visited;
  public void DFS(int L){
    if(L==m){
      for(int x: pm) System.out.print(x+" ");
      System.out.println();
    }
    else {
      for(int i=0; i<n; i++){
        if(visited[i]==0){
          visited[i]=1;
          pm[L]=arr[i];
          DFS(L+1);
          visited[i]=0;
        }
      }
    }
  }
  
  public static void main(String[] args) {
    DBFS_06 T = new DBFS_06();
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    arr = new int[n];
    visited = new int[n];
    pm = new int[m];
    for(int i=0; i<n; i++) arr[i]=sc.nextInt();
    T.DFS(0);
    sc.close();
  }
}