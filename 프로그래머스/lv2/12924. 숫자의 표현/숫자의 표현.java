class Solution {
    
    public int solution(int n) {
        int answer = 0;
        
        //연속된 자연수들로 n을 표현하는 방법의 개수
        // = n의 약수 중 홀수의 개수
        for(int i = 1; i <= n; i+=2){   //i = 1,3,5...
            if(n % i == 0){ //i가 n의 약수라면
                answer++;
            }
        }
        
        return answer;
    }
}