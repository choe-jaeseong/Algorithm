import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(st.nextToken());


        int lp=0, rp=0, count=0, MIN = Integer.MAX_VALUE;
        int Lion=0;

        //lp rp 초기값 세팅
        while(lp<n && arr[lp]!=1) {lp++; rp++;}

        //투 포인터 시작
        while(rp < arr.length){
            if(arr[rp]==1){
                count++;
                Lion++;
                if(Lion>=k) {
                    MIN = Math.min(MIN, count); //MIN 업데이트.
                    count--; lp++; Lion--;
                    while(arr[lp] != 1) {count--; lp++;}
                }
                rp++;
            } else {
                count++;
                rp++;
            }
        }

        if(MIN == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(MIN);
    }
}