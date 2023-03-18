import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        
        int answer = 0;
        Arrays.sort(people);
        Deque <Integer> deq = new ArrayDeque<>();
        for(int a: people){
            deq.add(a);
        }

        while(!(deq.isEmpty())){
            // 가장 가벼운 사람과 탔는데도 limit 넘는다면,
            // 그 사람은 결국 혼자 타야한다...

            if(deq.peekFirst()+deq.peekLast() <= limit){
                deq.pollFirst(); //같이 타도 됨
            }
            deq.pollLast();
            answer++;
        }

        return answer;
    }
}