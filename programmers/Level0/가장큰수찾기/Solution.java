package Level0.가장큰수찾기;

public class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        for(int i=0; i<array.length; i++){
            if(answer[0]<array[i]){
                answer[0]=array[i];
                answer[1]=i;
            }
        }
        return answer;
    }

    //다른 풀이1
    public int[] solution1(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        int max = list.stream().max(Integer::compareTo).orElse(0);
        int index = list.indexOf(max);
        return new int[] {max, index};
    }
}
