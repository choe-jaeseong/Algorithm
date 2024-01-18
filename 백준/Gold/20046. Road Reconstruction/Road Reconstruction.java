import java.util.PriorityQueue;

public class Main {
    static int m, n;
    static int[][] arr = new int[1005][1005];
    static int[][] check = new int[1005][1005];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    static class Node implements Comparable<Node> {
        int y, x, num;

        public Node(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.num, o.num);
        }
    }

    static void BFS() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 1, arr[1][1]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowY = now.y;
            int nowX = now.x;
            int nowNum = now.num;

            if (check[nowY][nowX] <= nowNum) {
                continue;
            }

            check[nowY][nowX] = nowNum;

            if (nowY == m && nowX == n) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                int nextNum = nowNum + arr[nextY][nextX];

                if (nextNum < check[nextY][nextX] && nextY <= m && nextY > 0 && nextX > 0 && nextX <= n && arr[nextY][nextX] != -1) {
                    pq.offer(new Node(nextY, nextX, nextNum));
                }
            }
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        m = scanner.nextInt();
        n = scanner.nextInt();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        if (arr[1][1] == -1 || arr[m][n] == -1) {
            System.out.println(-1);
            return;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                check[i][j] = 200000000;
            }
        }

        BFS();

        if (check[m][n] == 200000000) {
            System.out.println(-1);
            return;
        }

        System.out.println(check[m][n]);
    }
}
