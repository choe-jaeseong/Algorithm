import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] paper = new int[100][100];
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j=x; j<x+10; j++){
                for(int k=y; k<y+10; k++){
                    if(paper[j][k]==1) continue;
                    paper[j][k] = 1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
