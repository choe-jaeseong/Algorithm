import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {

    
    private static final int LION = 1;
    private static final int APEACH = 0;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = stoi.apply(st.nextToken());
        }
        System.out.println(solution(n,k,arr));
    }

    public static int solution(int n,int k, int[] arr){
        int si = 0;
        int ei = 0;
        int lineCnt = 0;
        int result = INF;
        while(ei <= n){
            if(lineCnt < k){
                if(ei == n){
                    break;
                }
                if(arr[ei++] == LION){
                    lineCnt++;
                }
                continue;
            }
            if(lineCnt == k){
                result = Math.min(result, ei-si);
            }
            if(arr[si++] == LION){
                lineCnt--;
            }
        }
        
        //결과 출력
        if(result == INF){
            return -1;
        }
        return result;
    }
}