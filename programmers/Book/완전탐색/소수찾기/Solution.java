package Book.완전탐색.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
    private void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes){
        if(isPrime(acc)) primes.add(acc);

        //점화식 구현
        for(int i=0; i<numbers.length; i++){
            if(isUsed[i]) continue;

            int nextAcc = acc * 10 + numbers[i];
            
            isUsed[i] = true;
            // List<Integer> nextNumbers = new ArrayList<>(numbers);
            // nextNumbers.remove(i);
            getPrimes(nextAcc, numbers, isUsed, primes);
            isUsed[i] = false;
        }
    }
    public int solution(String nums){
        Set<Integer> primes = new HashSet<>();
        int[] numbers = nums.chars().map(c -> c - '0').toArray();
        // List<Integer> numbers = nums.chars()
        //         .map(c -> c - '0')
        //         .boxed()
        //         .collect(Collectors.toList());
        getPrimes(0, numbers, new boolean[numbers.length], primes);
        return primes.size();
    }
}
