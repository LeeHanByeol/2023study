import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        
        //모든 논문의 인용 횟수가 전체 논문 개수 n보다 큰 경우
        if(citations[0] >= citations.length){
            answer = citations.length;
        }
        
        //그 외
        for(int i = citations.length - 1; i >= 0; i--){
            if(citations[i] < citations.length-i){
                answer = citations.length - (++i);
                break;
            }
            if(citations[i] == citations.length-i){
                answer = citations[i];
                break;
            }
        }
        
        return answer;
    }
}