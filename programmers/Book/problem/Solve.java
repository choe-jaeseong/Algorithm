package Book.problem;

import java.math.BigInteger;

public class Solve {
    private BigInteger factorial(int n){
        BigInteger result = new BigInteger(1+"");
        for(int i=2; i<=n; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    private BigInteger countRoute(int x, int y){
        return factorial(x+y).divide(factorial(x)).divide(factorial(y));
    }


    private BigInteger totalRoute(int x, int y, int width, int height){
        BigInteger case1 = countRoute(x-1, y).multiply(countRoute(width - x, height - (y-1)));
        BigInteger case2 = countRoute(x, y-1).multiply(countRoute(width - (x-1), height - y));
        return case1.add(case2);
    }
    public int solution(int width, int height, int[][] diagonals){
        BigInteger answer = new BigInteger(0+"");
        for(int i =0; i<diagonals.length; i++){
            int x = diagonals[i][0];
            int y = diagonals[i][1];
            answer = answer.add(totalRoute(x, y, width, height));
        }
        return answer.mod(BigInteger.valueOf(10000019)).intValue();
    }
    public static void main(String[] args) {
        Solve T = new Solve();
        int[][] arr = {{17,19}};
        System.out.println(T.solution(51,37,arr));
    }
}
