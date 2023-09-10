import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        int lp=0, rp=0, MAX = 0;
        while(rp < n) {
            if(!map.keySet().contains(arr[rp])) {
                map.put(arr[rp], 1);
                MAX = Math.max(MAX, rp - lp + 1);
                rp++;
            }
            else {
                map.put(arr[rp], map.get(arr[rp])+1);
                if(map.get(arr[rp]) > k) {
                    while(arr[lp]!=arr[rp]) {
                        map.put(arr[lp], map.get(arr[lp])-1);
                        lp++;
                    }
                    map.put(arr[lp], map.get(arr[lp])-1);
                    lp++;
                }
                MAX = Math.max(MAX, rp - lp + 1);
                rp++;
            }
        }
        System.out.println(MAX);
    }
}
