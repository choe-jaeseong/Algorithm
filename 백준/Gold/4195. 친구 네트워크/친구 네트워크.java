import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private static HashMap<String, String> parents;
    private static HashMap<String, Integer> rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            parents = new HashMap<>();
            rank = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                String person1 = st.nextToken();
                String person2 = st.nextToken();
                parents.put(person1, parents.getOrDefault(person1, person1));
                parents.put(person2, parents.getOrDefault(person2, person2));
                rank.put(person1, rank.getOrDefault(person1, 1));
                rank.put(person2, rank.getOrDefault(person2, 1));

                int rank = union(person1, person2);
                sb.append(rank).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static int union(String v1, String v2) {
        String p1 = find(v1);
        String p2 = find(v2);
        if(p1.equals(p2)) return rank.get(p1);

        int r1 = rank.get(p1);
        int r2 = rank.get(p2);

        if(r1 < r2) {
            parents.put(p1, p2);    //원소의 개수가 더 큰 숫자를 root 로 삼음
            rank.put(p2, r1 + r2);
        } else {
            parents.put(p2, p1);
            rank.put(p1, r1 + r2);
        }
        return r1 + r2;
    }

    static String find(String v) {
        String parent = parents.get(v);
        if(parent.equals(v)) return parent;

        return find(parent);
    }
}