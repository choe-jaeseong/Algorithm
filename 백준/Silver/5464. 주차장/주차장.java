import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] parking;
    private static int totalSum = 0;
    private static Queue<Integer> waiting = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. 주차장 개수와 차량 개수를 입력받는다.
        int parkingNum = Integer.parseInt(st.nextToken());
        int carNum = Integer.parseInt(st.nextToken());

        //2. 주차장의 단위요금을 입력받는다.
        int[] unitFee = new int[parkingNum + 1];
        for(int i=1; i < unitFee.length; i++){
            unitFee[i] = Integer.parseInt(br.readLine());
        }

        //3. 차량의 무게를 입력받는다.
        int[] weight = new int[carNum + 1];
        for (int i = 1; i < weight.length; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        //4. 차량이 들어왔다 빠지는 순서를 입력받으면서, 주차 요금을 계산한다.
        parking = new int[parkingNum + 1];
        for(int i=0; i<carNum * 2; i++){

            int state = Integer.parseInt(br.readLine());

            if(state > 0) { //주차 하기
                int fee = parkingCar(state, unitFee, weight);
                totalSum += fee;
            } else {        //주차 빼기
                int fee = pullOutCar(-1 * state, unitFee, weight);
                totalSum += fee;
            }
        }

        //5. 총 합산한 주차 요금을 출력한다.
        System.out.println(totalSum);

        br.close();
    }

    private static int pullOutCar(int state, int[] unitFee, int[] weight) {

        int parkingIdx = 0;
        for(int i=1; i<parking.length; i++){
            if(parking[i] == state){
                parking[i] = 0;
                parkingIdx = i;
                break;
            }
        }

        if(!waiting.isEmpty()) {
            int currentCar = waiting.poll();
            parking[parkingIdx] = currentCar;
            return unitFee[parkingIdx] * weight[currentCar];
        }

        return 0;
    }

    private static int parkingCar(int state, int[] unitFee, int[] weight) {

        waiting.add(state);

        //주차 공간이 비어있으면 해당 자리에 주차하기
        int parkingIdx = findParkingIdx();
        if(parkingIdx != -1) {
            int currentCar = waiting.poll();
            parking[parkingIdx] = currentCar;
            return unitFee[parkingIdx] * weight[currentCar];
        }
        return 0;
    }

    private static int findParkingIdx() {
        for(int i=1; i<parking.length; i++){
            if(parking[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}