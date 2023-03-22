import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; ){
            int max = (int)Math.ceil((double)(100-progresses[i]) / speeds[i]);
            int count = 0;
            do{
                i++;
                count++;
            } while(i < progresses.length && max >= (int)Math.ceil((double)(100-progresses[i]) / speeds[i]));

            queue.add(count);
        }

        int size = queue.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = queue.poll();
        }
        return answer;
    }
}