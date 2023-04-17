package 고득점kit.스택_큐.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 1. 트럭 클래스를 만든다. 현재 위치, 무게
 * 2. 하중을 넘지 않는다면 다음 차량이 다리에 오른다.
 * 3. 현재위치가 다리 길이가 되면 Queue로 빠져나간다.
 */
class Truck{
    int pos=0;
    int weight;
    Truck(int w){
        weight = w;
    }
}
public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1, total_weight = 0;
        Queue<Truck> Q = new LinkedList<>();
        Queue<Truck> Road = new LinkedList<>();
        for(int x : truck_weights){
            Q.offer(new Truck(x));
        }
        Road.add(Q.poll());
        total_weight+=Road.peek().weight;
        while(!Road.isEmpty()){
            time++;                             //시간이 1초 지나면
            for(Truck x : Road){                //각 트럭의 이동거리 1씩 증가
                x.pos++;
            }
            if(Road.peek().pos==bridge_length) {//이동거리가 다리길이와 같다면 poll
                Truck tmp = Road.poll();
                total_weight-=tmp.weight;
                tmp = null;
            }
            if(!Q.isEmpty() && total_weight+Q.peek().weight<=weight){//하중 무게 이하라면 다음 트럭이 출발
                Truck tmp = Q.poll();
                total_weight+=tmp.weight;
                Road.add(tmp);
                tmp=null; //???????
            }
        }
        return time;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {7,4,5,6};
        System.out.println(T.solution(2, 10, arr));
    }
}
