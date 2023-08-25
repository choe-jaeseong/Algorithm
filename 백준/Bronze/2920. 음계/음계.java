import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];
        for(int i=0; i<8; i++) arr[i] = Integer.parseInt(st.nextToken());

        int k=0;
        if(arr[0] == 1){
            while(k<8 && arr[k]==k+1) k++;
            if(k==8) System.out.println("ascending");
            else System.out.println("mixed");
        } else if (arr[0] == 8){
            while(k<8 && arr[k]==8-k) k++;
            if(k==8) System.out.println("descending");
            else System.out.println("mixed");
        } else {
            System.out.println("mixed");
        }
    }
}
