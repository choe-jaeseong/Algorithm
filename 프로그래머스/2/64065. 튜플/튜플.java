import java.util.*;

class Solution {
    
    
    public int[] solution(String s) {
        int[][] arr = parse(s);
        
        Arrays.sort(arr, (a1, a2) -> a1.length - a2.length);
        
        int[] lastArr = arr[arr.length - 1];
        int[] answer = new int[lastArr.length];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            for(int x : arr[i]) {
                if(!set.contains(x)) {
                    set.add(x);
                    answer[i] = x;
                    break;
                }
            }
        }
        return answer;
    }
    
    private static int[][] parse(String s) {
        if(!s.contains(",")) {
            int x = Integer.parseInt(s.replace("{", "").replace("}", ""));
            int[] arr = new int[]{x};
            int[][] result = new int[1][];
            result[0] = arr;
            return result;
        } else {
            String[] arrs = s.replace("},{", " ").replace("{", "").replace("}", "").split(" ");
            int[][] result = new int[arrs.length][];
            for(int i=0; i<arrs.length; i++) {
                String[] arr = arrs[i].split(",");
                int[] arrToInt = new int[arr.length];
                for(int j=0; j<arr.length; j++) {
                    arrToInt[j] = Integer.parseInt(arr[j]);
                }
                result[i] = arrToInt;
            }
            return result;
        }
    } 
}
