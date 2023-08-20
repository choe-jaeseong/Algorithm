import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int getCountConsecutive(int[] arr, int index){
        int ascend = 1;
        int descend = 1;
        for(int i=index+1; i<arr.length; i++){
            if(arr[i-1] <= arr[i]) ascend++;
            else break;
        }
        for(int i=index+1; i<arr.length; i++){
            if(arr[i-1] >= arr[i]) descend++;
            else break;
        }
        return ascend > descend ? ascend : descend;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int longest = 0;
        for(int i=0; i<arr.length; i++){
            if(longest > arr.length - i) break;
            int tmp = getCountConsecutive(arr, i);
            longest = longest < tmp ? tmp : longest;
        }
        System.out.println(longest);
    }
}
