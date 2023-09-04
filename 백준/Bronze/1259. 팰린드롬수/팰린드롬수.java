import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        while(target != 0){
            if(isPalindrom(target)) System.out.println("yes");
            else System.out.println("no");
            target = Integer.parseInt(br.readLine());
        }
    }
    private static boolean isPalindrom(int target) {
        String str = String.valueOf(target);
        int lp = 0, rp = str.length()-1;
        while(lp < rp){
            if(str.charAt(lp) != str.charAt(rp)) return false;
            lp++;
            rp--;
        }
        return true;
    }
}
