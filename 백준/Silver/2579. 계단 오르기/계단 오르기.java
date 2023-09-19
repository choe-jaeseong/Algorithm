import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N];
		for (int i = 0; i < stairs.length; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		//score 배열 생성
		int[][] scores = new int[N][2];
		
		//N=1 or 2 일 때
		if(N==1) {
			System.out.println(stairs[0]);
			return;
		}
		if(N==2) {
			System.out.println(stairs[0] + stairs[1]);
			return;
		}
		
		//0, 1 번째 계단 초기화
		scores[0][0] = stairs[0];
		scores[0][1] = stairs[0];
		scores[1][0] = stairs[0] + stairs[1];
		scores[1][1] = stairs[1];
		
		//DP : 2번째 계단부터 N-1까지
		for(int i=2; i<N; i++) {
			scores[i][0] = scores[i-1][1] + stairs[i];
			scores[i][1] = Math.max(scores[i-2][0], scores[i-2][1]) + stairs[i];
		}
		
		System.out.println(Math.max(scores[N-1][0], scores[N-1][1]));
	}
}


/*
 * DP
 * 
 * target = 현재 계단이 가질 수 있는 최대 점수
 * 
 * scores[i][0] : i번째 계단이 한 칸 전 계단과 이어진 경우 최대 점수 (현재 계단 점수 + 한 칸 전 계단의 두 칸전 계단과 이어진 경우의 점수)
 * scores[i][1] : i번째 계단이 두 칸 전 계단과 이어진 경우 최대 점수 (현재 계단 점수 + 두 칸 전 계단의 최대 점수)
 * 
 * scores[k] = Math.max(scores[k][0], scores[k][1])
 */

