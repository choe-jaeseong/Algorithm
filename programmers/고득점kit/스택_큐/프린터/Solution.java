package 고득점kit.스택_큐.프린터;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Document{
    int idx;
    int priority;
    Document(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}
public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Document> Q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            Q.offer(new Document(i, priorities[i]));
        }
        while(!Q.isEmpty()){
            Document tmp = Q.poll();
            for(Document x : Q){
                if(tmp.priority < x.priority) {
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp!=null){
                if(tmp.idx==location) return answer;
                else answer++;
            }
        }
        return answer;
    }

    //다른 풀이
    public int solution1(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;

        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}
