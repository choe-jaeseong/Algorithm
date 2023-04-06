package Level1.소수만들기;

public class Solution {
    public boolean isPrime(int n){
        for(int i=2; i*i<=n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(isPrime(nums[i]+nums[j]+nums[k])) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1,2,3,4};
        System.out.println(T.solution(arr));
    }
}
