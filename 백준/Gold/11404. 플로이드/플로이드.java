import java.util.*;

public class Main {

    static int[][] node;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        node = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                node[i][j] = 100000001;
            }
            node[i][i] = 0;
        }

        for(int i = 0; i < m; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            int cost = scan.nextInt();
            node[start][end] = Math.min(node[start][end], cost);
        }

        //플로이드-워샬
        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < n + 1; j++) {
                    if(node[i][j] > node[i][k] + node[k][j])
                        node[i][j] = node[i][k] + node[k][j];
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(node[i][j] == 100000001) System.out.print("0 "); //i -> j로 갈 수 없는 경우 0출력
                else System.out.print(node[i][j] + " ");
            }
            System.out.println();
        }
    }
}