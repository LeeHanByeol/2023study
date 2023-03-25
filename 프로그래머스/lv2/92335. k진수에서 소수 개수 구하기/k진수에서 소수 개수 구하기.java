import java.util.*;

class Solution {
    public int solution(int n, int k) {

        //k진수로 변환
        String str = "";
        while(n != 0){
            str = (n%k) + str;
            n /= k;
        }
        
        //조건 만족하게 나눠줌
        String[] P = str.split("0+");

        //10진수로 변환해서 소수이면 answer++
        int answer = 0;
        for(String a : P){
            if(isPrime(Long.parseLong(a))){
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