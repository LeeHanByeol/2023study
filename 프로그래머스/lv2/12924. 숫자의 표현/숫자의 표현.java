//정수론 중...
//연속된 자연수들의 합으로 n을 표현하는 방법의 개수
// = n의 약수 중 홀수의 개수


class Solution {
    
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i+=2){   //i = 1,3,5...
            if(n % i == 0){ //i가 n의 약수라면
                answer++;
            }
        }
        
        return answer;
    }
}
