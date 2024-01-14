import java.io.*;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G + 1];
        for(int i=1; i<=G; i++) parent[i] = i;

        int answer = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int emptyGate = find(g);

            if(emptyGate == 0) break;

            answer++;
            union(emptyGate, emptyGate - 1);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int g1, int g2) {
        int p1 = find(g1);
        int p2 = find(g2);

        if(p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
    }

    static int find(int gate) {
        int p = parent[gate];
        if(p == gate) return p;

        return parent[gate] = find(p);
    }
}