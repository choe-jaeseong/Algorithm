import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int[][] stores = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            stores[i][0] = Integer.parseInt(st.nextToken());  //direction
            stores[i][1] = Integer.parseInt(st.nextToken());  //간격
        }

        //동근이 위치
        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int dis = Integer.parseInt(st.nextToken());

        //동근이와 각 상점 간 최단 거리 합
        int sum = 0;
        for(int i=0; i<N; i++){
            sum += getShortDistance(dir, dis, stores[i], W, H);;
        }
        System.out.println(sum);
    }

    private static int getShortDistance(int dir, int dis, int[] store, int W, int H) {
        int leftRoute = 0;
        int rightRoute = 0;

        if(dir==store[0]){
            return Math.abs(dis - store[1]);
        }
        else if(dir < 3 && store[0] < 3){
            leftRoute = dis + store[1] + H;
            rightRoute = 2 * W - dis - store[1] + H;
        }
        else if(dir >= 3 && store[0] >= 3) {
            leftRoute = dis + store[1] + W;
            rightRoute = 2 * H - dis - store[1] + W;
        }
        else if(dir == 1){
            if(store[0]==3){
                return dis + store[1];
            } else {
                return W - dis + store[1];
            }
        }
        else if(dir == 2){
            if(store[0]==3){
                return dis + H - store[1];
            } else {
                return W - dis + H - store[1];
            }
        }
        else if(dir == 3){
            if(store[0]==1){
                return dis + store[1];
            } else {
                return H - dis + store[1];
            }
        }
        else if(dir == 4){
            if(store[0]==1){
                return dis + W - store[1];
            } else {
                return H - dis + W - store[1];
            }
        }

        return leftRoute < rightRoute ? leftRoute : rightRoute;
    }
}

/*
1. 맵의 크기와 상점의 숫자 및 위치, 그리고 동근이 위치 입력
2. 상점마다 동근이 위치로부터 최단거리를 sum 에 더한다.
    최단 거리 구하는 법
        1. 동근이 위치에 따른 상점 계산 방식 설정.
            1인데 3인경우 left = 거리 + 그자식 거리 + 높이
            1인데 2인경우 left = 거리 + 그자식 거리
 */