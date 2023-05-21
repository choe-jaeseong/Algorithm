package 큐.우선순위큐.이중우선순위큐;

import java.util.PriorityQueue;

public class Solution {

    private static class DoublePriorityQueue {
        private int size = 0;
        private final PriorityQueue<Integer> minPq = new PriorityQueue<>();
        private final PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
        
        public void add (int value) {
            size++;
            minPq.add(value);
            maxPq.add(value);
        }

        public void removeMax() {
            if(size == 0) return;
            maxPq.poll();
            if(--size == 0) {
                maxPq.clear();
                minPq.clear();
            }
        }

        public void removeMin() {
            if(size == 0) return;
            minPq.poll();
            if(--size == 0) {
                maxPq.clear();
                minPq.clear();
            }
        }

        public int max() {
            if(size == 0) return 0;
            return maxPq.peek();
        }

        public int min() {
            if(size == 0) return 0;
            return minPq.peek();
        }
    }

    public int[] solution(String[] operations) {
        DoublePriorityQueue dpq = new DoublePriorityQueue();

        for(String operation : operations) {
            String[] tokens = operation.split(" ");
            String command = tokens[0];
            String value = tokens[1];
            switch(command) {
                case "I" -> dpq.add(Integer.parseInt(value));
                case "D" -> {
                    if (value.equals("1")) {
                        dpq.removeMax();
                    } else {
                        dpq.removeMin();
                    }
                }
            }
        }
        return new int[] {dpq.max(), dpq.min()};
    }
}
