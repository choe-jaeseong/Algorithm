package etc.유니온파인드.basic;

//최적화된 방법
public class Solution1 {
    private static class Node {
        private Node parent = null;

        public boolean isConnected(Node o) {
            return root() == o.root();
        }

        public void merge(Node o) {
            if(isConnected(o)) return;
            o.parent = this;
        }

        private Node root() {
            if (parent == null) return this;
            return parent = parent.root();
        }
    }
}
