import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea {
    static char[][] arr;
    static boolean[][] visited;
    static int n,r,c, total;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            total = 0;

            arr = new char[r][c];
            visited = new boolean[r][c];

            //지도입력
            for(int j = 0; j < r; j++){                 
                String input = br.readLine();
                for(int k = 0; k< c; k++){
                    arr[j][k] = input.charAt(k);
                }
            }

            for(int j = 0; j < r; j++){              
                for(int k = 0; k< c; k++){
                    System.out.println(arr[j][k] + "");
                }
                System.out.println();
            }
        }
        br.close();
    }
}