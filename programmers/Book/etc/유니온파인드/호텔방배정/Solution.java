package etc.유니온파인드.호텔방배정;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
        private static class Node {
            private Node parent = null;
            private long max;
            
            public Node (long value) {
                max = value;
            }

            public long max() {
                return root().max;
            }

            private Node root() {
                if (parent == null) return this;
                return parent = parent.root();
            }

            public boolean isConnected(Node o) {
                return root() == o.root();
            }

            public void merge(Node o) {
                if (isConnected(o)) return;

                root().max = o.root().max = Math.max(root().max, o.root().max);

                o.parent = this;
            }
        }
    }

    public long[] solution(long k, long[] room_numbers) {
        List<Long> assigned = new ArrayList<>();

        //유니온 파인드 수행
        Map<Long, Node> nodes = new HashMap<>();
        for (long number : room_numbers) {
            if (nodes.containsKey(number)) {
                number = nodes.get(number).max() + 1;
            }

            //number 방 실제 배정하기
            Node node = new Node(number);
            nodes.put(number, node);
            if (nodes.containsKey(number - 1)) {
                node.merge(nodes.get(number - 1));
            }
            if (nodes.containsKey(number + 1)) {
                node.merge(nodes.get(number + 1));
            }

            assigned.add(number);
        }

        return assigned.stream().mapToLong(Long::longValue).toArray();
    }
    
}
