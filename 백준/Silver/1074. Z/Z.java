import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean flag;
    private static int count = 0;
    private static int[] answer = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
        answer[0] = Integer.parseInt(st.nextToken()); //x
        answer[1] = Integer.parseInt(st.nextToken()); //y

        DFS(N, 0, 0);
    }
    private static void DFS(int N, int x, int y){
        if(flag) return;
        int unit = N/2;
        if(unit==1){
            for(int i=x; i<x+N; i++){
                for(int j=y; j<y+N; j++){
                    if(i==answer[0] && j==answer[1]){
                        System.out.println(count);
                        flag = true;
                        return;
                    }
                    count++;
                }
            }
        } else {
            for(int i=x; i<x+N; i+=unit){
                for(int j=y; j<y+N; j+=unit){
                    if(answer[0]>=i && answer[0]<i+unit && answer[1]>=j && answer[1]<j+unit)
                        DFS(unit, i, j);
                    else
                        count += Math.pow(unit, 2);
                }
            }
        }
    }
}