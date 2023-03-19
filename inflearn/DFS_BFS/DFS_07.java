package DFS_BFS;
//9.Tree 말단노드까지의 가장 짧은 경로(DFS)
class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt=rt=null;
    }
}

public class DFS_07 {
    Node root;
    public int DFS(int L, Node root){
        if(root.lt==null && root.rt==null) return L;
        else return Math.min(DFS(L+1,root.lt), DFS(L+1,root.rt));
    }

    public static void main(String[] args) {
        DFS_07 tree = new DFS_07();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}
