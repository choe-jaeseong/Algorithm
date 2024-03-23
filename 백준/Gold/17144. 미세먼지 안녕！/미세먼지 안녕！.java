import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int totalPM = 0;
    static int[][] arr, cleaner;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        cleaner = new int[2][2];
        int idx_cleaner = 0;
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1) {
                    cleaner[idx_cleaner][0] = i;
                    cleaner[idx_cleaner][1] = j;
                    idx_cleaner++;
                } else {
                    totalPM += arr[i][j];
                }
            }
        }

        for(int i=0; i<t; i++) {
            spread();
            clean(cleaner);
        }

        System.out.println(totalPM);
    }

    private static void printMap(int[][] arr) {
            for(int[] x : arr) {
                for(int y : x) System.out.print(y + " ");
                System.out.println();
            }
            System.out.println("---------------");
    }


    static int[] dxx = {-1,0,1,0};
    static int[] dyy = {0,1,0,-1};
    static int[] dxxx = {1,0,-1,0};
    static int[] dyyy = {0,1,0,-1};
    private static void clean(int[][] cleaner) {
        //첫 번째
        int x = cleaner[0][0];
        int y = cleaner[0][1];
        for(int i=0; i<4; i++) {    //상우하좌
            while(true) {
                int nx = x + dxx[i];
                int ny = y + dyy[i];
                if(!(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length)) break;
                if(nx > cleaner[0][0]) break;
                if(arr[nx][ny] == -1) break;
                if(arr[x][y] == -1) totalPM -= arr[nx][ny];
                else arr[x][y] = arr[nx][ny];
                arr[nx][ny] = 0;

                x = nx;
                y = ny;
            }
        }

        //두 번째
        x = cleaner[1][0];
        y = cleaner[1][1];
        for(int i=0; i<4; i++) {    //상우하좌
            while(true) {
                int nx = x + dxxx[i];
                int ny = y + dyyy[i];
                if(!(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length)) break;
                if(nx < cleaner[1][0]) break;
                if(arr[nx][ny] == -1) break;
                if(arr[x][y] == -1) totalPM -= arr[nx][ny];
                else arr[x][y] = arr[nx][ny];
                arr[nx][ny] = 0;

                x = nx;
                y = ny;
            }
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    private static void spread() {
        int[][] newMap = new int[arr.length][arr[0].length];
        newMap[cleaner[0][0]][cleaner[0][1]] = -1;
        newMap[cleaner[1][0]][cleaner[1][1]] = -1;

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] == 0 || arr[i][j] == -1) continue;
                int curPM = arr[i][j];
                int amount = curPM / 5;

                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(!(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length)) continue;
                    if(arr[nx][ny] == -1) continue;

                    newMap[nx][ny] += amount;
                    curPM -= amount;
                }

                newMap[i][j] += curPM;
            }
        }

        arr = newMap;
    }

}

/*
1. 값을 입력받는다. (R행 , C열 , T초)
2. 초마다 확산, 청정기 작동이 이루어진다.
3. T 초 반복.
 */