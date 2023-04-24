import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;                      //부분 수열 시작 인덱스
        int end = sequence.length - 1;      //부분 수열 마지막 인덱스
        int sum = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < sequence.length; i++){
                        
            if(sum < k){
                queue.add(sequence[i]);
                sum += sequence[i];
            }

            while(sum > k){
                sum -= queue.poll();
            }                        
            
            if(sum == k){
                int len = queue.size();
                if(len < (end-start+1)){
                    end = i;
                    start = i - len + 1;                    
                }
                sum -= queue.poll();
            }
        }
        
        return new int[]{start, end};
    }
}