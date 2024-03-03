import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(0);
            return;
        }

        boolean[] ch = new boolean[4000_001];
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i=2; i<=N; i++) {
            if(ch[i]==false) {
                primes.add(i);
                for(int j=i; j<=N; j+=i)
                    ch[j] = true;
            }
        }

        int lp = 0, rp = 0, sum = primes.get(0);
        int count = 0;
        while(rp < primes.size() && lp <= rp) {
            if(sum == N) {
                count++;
                rp++;

                if(rp == primes.size()) break;
                else sum += primes.get(rp);
            }
            else if(sum < N) {
                rp++;

                if(rp == primes.size()) break;
                else sum += primes.get(rp);
            } else {
                sum -= primes.get(lp);
                lp++;
            }
        }

        System.out.println(count);
    }
}
