import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) q.add(i);
        int round = 1;
        while(!q.isEmpty()) {
            Queue<Integer> next = new LinkedList<>();
            while(!q.isEmpty()) {
                int t1 = q.poll();
                int t2 = q.poll();
                if(t1 == a && t2 == b) return round;
                if(t1 == b && t2 == a) return round;
                if(t1 == a || t1 == b) next.add(t1);
                else next.add(t2);
            }
            q = next;
            round++;
        }
        return round;
    }
}