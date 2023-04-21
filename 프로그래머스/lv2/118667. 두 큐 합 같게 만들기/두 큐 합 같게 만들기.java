import java.util.*;
class Solution {

    long sum1 = 0;
    long sum2 = 0;
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();            
    
    public int solution(int[] queue1, int[] queue2) {
        /////////////전처리 과정//////////
        for(int a : queue1){
            q1.add(a);
            sum1 += a;
        }
        for(int a : queue2){
            q2.add(a);
            sum2 += a;
        }
        /////////////////////////////////
        
        if(sum1 == sum2){
            return 0;
        }                
        if((sum1-sum2)%2 != 0){             //합의 차가 홀수이면 답을 구할 수 없다
            return -1;
        }
        
        return op(queue1.length*3);         //최대 이동횟수는 3n-3; n=큐의 초기 길이
    }
    
    public int op(int max){
        
        int cnt = 0;
        int answer = 0;
        while(!q1.isEmpty() && !q2.isEmpty() && cnt < max){

            if(sum1 == sum2){
                return answer;
            }
            
            //합이 큰쪽에서 pop, 작은 쪽에 insert
            if(sum1 > sum2){
                int num = q1.poll();
                sum1 -= num;
                q2.add(num);
                sum2 += num;
            }
            else{   //sum1 < sum2
                int num = q2.poll();
                sum2 -= num;
                q1.add(num);
                sum1 += num;
            }
            cnt++;
            answer++;
        }
        
        return -1;
    }
    
}