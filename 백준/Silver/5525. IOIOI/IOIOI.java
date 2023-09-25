import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.readLine();
        char[] S = br.readLine().toCharArray();
        char[] P = ("I"+"OI".repeat(N)).toCharArray();

        int count = 0;
        for(int i=0; i<S.length - (P.length-1); i++){
            if(isExist(S, P, i)) count++;
        }

        System.out.println(count);
    }

    private static boolean isExist(char[] s, char[] p, int start) {
        for(int i=0; i<p.length; i++){
            if(p[i]!=s[start++]) return false;
        }
        return true;
    }
}
