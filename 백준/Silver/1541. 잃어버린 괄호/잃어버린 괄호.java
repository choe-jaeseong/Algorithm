import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 숫자와 연산자를 구분해서 파싱한다.
        String expression = br.readLine();
        String[] num_str = expression.split("[+-]");
        String[] operation = expression.replaceAll("[0-9]", "").split("");

        //문자열인 숫자 배열을 int 로 변환
        int[] nums = new int[num_str.length];
        for(int i=0; i<nums.length; i++) nums[i] = Integer.parseInt(num_str[i]);

        //2. 첫 숫자를 결과값으로 초기화한다.
        int result = nums[0];

        //예외 처리
        if(operation.length == 1 && operation[0].equals("")) {
            System.out.println(result);
            return;
        }

        //3. 연산자와 함께 다음 숫자값을 이용한다.
        int idx_nums = 1;
        int idx_op = 0;
        for(idx_op = 0; idx_op < operation.length; idx_op++){
            if(operation[idx_op].equals("+")){
                result += nums[idx_nums++];
            } else {
                int sum = nums[idx_nums++];
                //다음 연산자 확인
                idx_op++;
                while(idx_op < operation.length && operation[idx_op].equals("+")){
                    sum += nums[idx_nums++];
                    idx_op++;
                }
                result -= sum;
                idx_op--;
            }
        }

        //4. 결과 출력
        System.out.println(result);
    }
}

/*
아이디어
1. + 또는 - 연산자만 있는 상태에서 괄호를 이용해 최소의 결과값을 구해야 한다.
2. - 연산자 뒤의 수식이 최대가 될 때 빼도록 괄호를 묶는다.

코드 구현
1. 숫자와 연산자를 구분해서 파싱한다.
2. 첫 숫자를 결과값으로 초기화한다.
3. 연산자와 함께 다음 숫자값을 이용한다.
    - 일 경우, 괄호가 시작되며 뒤에 부호가 - 가 아닐 때까지 숫자를 합한다.
    + 일 경우, 결과값에 숫자를 더한다.
 */