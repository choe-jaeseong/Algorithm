package 큐.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            bridge.add(0);
        }

        int time = 0;
        int truckIndex = 0;
        while(truckIndex < truck_weights.length) {
            time++;
            bridgeWeight -= bridge.poll();

            int truck_weight = truck_weights[truckIndex];
            if(bridgeWeight + truck_weight > weight){
                bridge.add(0);
            } else {
                bridge.add(truck_weight);
                bridgeWeight += truck_weight;
                truckIndex++;
            }
        }
        while(bridgeWeight > 0){
            time++;
            bridgeWeight -= bridge.poll();
        }
        return time;
    }
}
