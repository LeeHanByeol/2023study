import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {

        Queue<Integer> under_K = new PriorityQueue<>(scoville.length);
        for(int i = 0; i < scoville.length; i++){
            under_K.add(scoville[i]);
        }

        int answer = 0;        
        while(under_K.size() > 1 && under_K.peek() < K){
            answer++;
            int mixed = under_K.poll() + (under_K.poll()<<1);
            under_K.add(mixed);
        }
        
        return (under_K.peek() < K) ? -1 : answer;
    }
}