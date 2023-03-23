import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int[][] data = new int[priorities.length][2];   //중요도와 초기 위치 정보
        for(int i = 0; i < priorities.length; i++){
            data[i][0] = priorities[i]; //중요도
            data[i][1] = i;     //초기 위치
        }
        
        //Queue에 전부 집어넣음
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < data.length; i++){
            queue.add(data[i]);
        }
        
        //중요도순으로 priority 정렬(오름차순)
        Arrays.sort(priorities);
        
        int turn = 1;
        for(int i = priorities.length - 1; i >= 0; i--){
            
            int[] temp = queue.poll();
            while(priorities[i] != temp[0]){
                queue.add(temp);
                temp = queue.poll();
            }
            if(temp[1] == location){
                return turn;
            }
            turn++;
        }
        
        
        return -1;
    }
}