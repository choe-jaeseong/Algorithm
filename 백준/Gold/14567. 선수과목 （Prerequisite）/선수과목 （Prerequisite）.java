import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] order, parentCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //과목 그래프 형성
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> subjects = new ArrayList<>();
        for(int i=0; i<N+1; i++) subjects.add(new ArrayList<>());
        order = new int[N+1];       //순서 정보 입력될 배열
        parentCnt = new int[N+1];       //순서 정보 입력될 배열

        //선수과목 정보 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            subjects.get(a).add(b);
            parentCnt[b]++;
        }

        //순서 정보 입력
        BFS(subjects);

        //결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) sb.append(order[i] + " ");
        System.out.println(sb.toString());
    }

    //순서 정보 담기
    private static void BFS(ArrayList<ArrayList<Integer>> subjects) {
        //후수 과목이 없는 과목 넣기
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1; i<parentCnt.length; i++){
            if(parentCnt[i]==0) {
                order[i] = 1;
                Q.add(i);
            }
        }

        //순서 정하기
        int time = 2;	//현재 학기
        while(!Q.isEmpty()){
        	int size = Q.size();
        	for(int i=0; i<size; i++) {
        		int now = Q.poll();
        		for(int next: subjects.get(now)) {	//now 라는 선수과목(부모)이 사라지면서 자식들의 부모 개수를 1씩 제거
        			if(order[next]==0) {
        				parentCnt[next]--;
        				if(parentCnt[next]==0) { //선수과목이 없다면 다음 학기에 수강
        					order[next] = time;
        					Q.add(next);
        				}
        			}
        		}
        	}
        	time++;
        }
    }
}

/*
 * 1. 선수 과목을 저장.
 * 2. 선수 과목이 없으면, 출발 지점
 * 3. 거꾸로 시작
 * 
 * 
 * */

