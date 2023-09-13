import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                makeStars(N, i, j);
            }
            bw.write('\n');
            bw.flush();
        }
    }

    private static void makeStars(int n, int x, int y) throws IOException {
        if(x / n % 3 == 1 && y / n % 3 == 1)
            bw.write(' ');
        else if (n / 3 == 0)
            bw.write("*");
        else
            makeStars(n/3, x, y);
    }
}
