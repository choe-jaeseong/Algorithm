//3. 최대 매출
import java.util.*;

public class EFF_03 {

    public int solution(int day, int n, int[] sales){
        int max = 0, price = 0;
        for (int i=0; i<n; i++){
            price += sales[i];
        }
        max = price;
        for (int j=n; j<day-n+1; j++){
            price += (sales[j] - sales[j-n]);
            if (max < price) max = price;
        }
        return max;
    }
    
    public static void main(String[] args){
        EFF_03 T = new EFF_03();
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int n = sc.nextInt();
        int[] sales = new int[day];
        for (int i=0; i<day; i++){
            sales[i] = sc.nextInt();
        }
        System.out.print(T.solution(day, n, sales));
        sc.close();
    }
}
