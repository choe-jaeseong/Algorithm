import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

				//목표 : 랜선의 최대 길이 구하기
				//lp = 랜선의 최대길이의 최솟값. rp = 랜선의 최대길이의 최댓값. mp는 lp와 rp의 중간값
        long lp = 1, rp = 0, mp;
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

				//랜선 길이 입력
        long[] lines = new long[k];
        for(int i=0; i<k; i++) {
            lines[i] = Long.parseLong(br.readLine());

						//랜선의 최댓값 지정(= rp)
            rp = Math.max(rp, lines[i]);
        }

				//이분 탐색  [lp, rp) 범위로 진행. 랜선 최댓값도 정답이 될 수 있기 때문에 오른쪽 범위 1 증가
        rp++;

        //이분 탐색 시작
        while(lp < rp){
            //중간값(=mp) 설정
            mp = (lp + rp) / 2;

            //원하는 갯수(=n)를 만들 수 있다면, 탐색 공간을 오른쪽으로 제한. 불가능하다면 왼쪽으로 제한.
            if(isPossible(mp, lines, n)) lp = mp+1;
            else rp = mp;
        }

				//isPossible 을 통과한 mp 는 lp = mp + 1 형태로 남아있기 때문에, lp-1한 값을 출력
        System.out.println(lp - 1);
    }

    private static boolean isPossible(long mp, long[] lines, int N) {
        //각 랜선에서 해당 길이(=mp)로 만들 수 있는 조각의 개수
        int count = 0;

        //조각 수 세기
        for(long line : lines) count += line / mp;
        
        //조각이 원하는 개수(=n)보다 작으면 false. 아니면 true.
        return count < N ? false : true;
    }

}
/*
1. 갖고 있는 랜선의 길이를 저장. 최댓값 확인(=rp)
2. 정답의 범위 : lp = 1, rp = 최댓값
3. 분할 정복 : while(lp < rp)
 */