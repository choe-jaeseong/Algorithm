import java.util.*;

class Solution {
    
    static HashMap<String, Integer> map = new HashMap<>();
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        //이름을 번호로 등록
        for(int i=0; i<friends.length; i++) {
            map.put(friends[i], i);
        }
        // for(String key: map.keySet()){
        //     System.out.println(map.get(key));
        // }
        
        //선물 내역 정리
        int[][] arr = new int[friends.length][friends.length];
        for(String gift : gifts) {
            String[] people = gift.split(" ");
            int p1 = map.get(people[0]);
            int p2 = map.get(people[1]);
            arr[p1][p2]++;
        }
        // for(int[] x : arr) {
        //     for(int y : x) System.out.print(y+" ");
        //     System.out.println();
        // }
        
        //선물 지수 정리
        int[] factor = new int[friends.length];
        for(int i=0; i<factor.length; i++){
            for(int j=0; j<factor.length; j++) {
                factor[i] += arr[i][j];
                factor[i] -= arr[j][i];
            }
        }
        // for(int x : factor) System.out.print(x + " ");
        
        //판단 로직
        int[] nextGift = new int[friends.length];
        for(int i=0; i<friends.length; i++) {
            for(int j=0; j<friends.length; j++) {
                if(i == j) continue;
                if (arr[i][j] < arr[j][i]) nextGift[j]++;
                else if (arr[i][j] > arr[j][i]) nextGift[i]++;
                else {
                    if(factor[i] == factor[j]) continue;
                    else if(factor[i] < factor[j]) nextGift[j]++;
                    else nextGift[i]++;
                }
            }
        }
        
        for(int i=0; i<nextGift.length; i++) 
            answer = Math.max(answer, nextGift[i]/2);
        
        return answer;
    }
}

/*
1. 선물 주고 받은 내역 배열(arr)을 생성한다.(friend 이름을 해시로 등록한다.)
2. arr 를 바탕으로 선물 지수를 만든다.
3. 한명 한명에게 몇 개를 받을지 판단한다. (주고 받은 선물의 개수 비교 후, 같으면 선물지수 비교, 같으면 0)
4. 가장 많이 받은 선물 수를 반환한다.
*/