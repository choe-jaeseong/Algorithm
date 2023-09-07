import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        if(isPossible(S, T)) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean isPossible(String s, String t) {
        StringBuilder sb = new StringBuilder(t);
        while(sb.length()>=s.length()){
            if(sb.toString().equals(s)) return true;
            if(sb.charAt(sb.length()-1)=='A') sb.deleteCharAt(sb.length()-1);
            else sb.deleteCharAt(sb.length()-1).reverse();
        }
        return false;
    }
}
