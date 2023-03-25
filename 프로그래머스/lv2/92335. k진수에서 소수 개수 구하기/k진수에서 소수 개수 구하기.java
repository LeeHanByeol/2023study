import java.util.*;

class Solution {
    public int solution(int n, int k) {

        //n을 k진수로 변환 & 조건에 부합하게 나눠줌
        String[] P = Integer.toString(n, k).split("0+");

        //10진수로 변환해서 소수이면 answer++
        int answer = 0;
        for(String a : P){
            if(isPrime(Long.parseLong(a))){ //int로 변환하면 runtime error
                answer++;
            }
        }
        
        return answer;
    }

    static boolean isPrime (long num){
        
        if(num == 1){
            return false;
        }
        
        //O(sqrt(n))
        for(long i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}