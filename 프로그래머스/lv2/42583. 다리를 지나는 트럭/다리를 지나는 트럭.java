import java.util.*;
class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> bridge = new LinkedList<>();        
        for(int i = 0; i < bridge_length; i++){   //다리 길이만큼 0으로 queue를 채워줌
            bridge.add(0);
        }
        
        int time = 0;       //경과 시간
        int sum = 0;        //적재량
        for(int w : truck_weights){
            
            while(true){
                sum -= bridge.poll();
                time++;
                if(sum + w > weight){   //과적 예상
                    bridge.add(0);
                }
                else{   //적재 가능
                    bridge.add(w);
                    sum += w;
                    break;
                }
            }
        }
        
        return time + bridge_length;        //마지막 트럭이 다리를 건너는데 걸리는 시간
    }    
}