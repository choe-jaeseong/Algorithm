import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int[] arr = new int[26];
        for(char c : word.toCharArray()){
            int num = c - 'a';
            arr[num]++;
        }

        //결과 출력
        for(int x : arr) System.out.print(x + " ");
    }
}
