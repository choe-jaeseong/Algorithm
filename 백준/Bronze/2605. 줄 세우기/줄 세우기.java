import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];
        for(int i=0; i<N; i++) line[i] = i+1;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int pick = Integer.parseInt(st.nextToken());
            for(int j=0; j<pick; j++)
                line[i - j] = line[i - j - 1];
            line[i - pick] = i+1;
        }
        
        //출력
        for(int x : line) System.out.print(x + " ");
    }
}
/*
1. 인원 수를 입력받는다. 배열에 자기 인덱스 입력하여 생성.
2. 뽑은 번호를 입력받으면서, 정렬한다.
 */