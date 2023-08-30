import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int MAX = 0;
    private static HashMap<Integer, ArrayList<Integer>> map1 = new HashMap<>();
    private static HashMap<Integer, Set<Integer>> map2 = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) map1.put(i, new ArrayList<>());
        for(int i=0; i<N; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<arr.length; j++){
                if(arr[j]=='Y') map1.get(i).add(j);
            }
        }

        for(int i=0; i<N; i++) map2.put(i, new HashSet<>());
        for(int i=0; i<N; i++) DFS(i, 0, map1.get(i));
        for(int i=0; i<N; i++) MAX = MAX < map2.get(i).size() ?  map2.get(i).size() : MAX;

        System.out.println(MAX);
    }

    private static void DFS(int friend, int L, ArrayList<Integer> list){
        if(L==2) return;
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int x : list){
            if(x == friend) continue;
            map2.get(x).add(friend);
            DFS(friend, L+1, map1.get(x));
        }
    }
}

/*
1. 거리가 1인 친구를 각각 구한다. Map <integer, Arraylist>
2. 거리가 2인 친구를 계산한다.   Map <integer, Set>
3. 가장 친구가 많을 때의 친구 수를 갱신한다.
 */