import java.util.*;
class Solution {
    
    int MAX = 10001;
    
    public int solution(int[] topping) {
        
        Set<Integer> Brother = new HashSet<>();     //동생이 가진 토핑 종류
        int[] brother = new int[MAX];               //index: 토핑 번호 value: 해당 토핑 개수
        for(int a : topping){                       //모두 동생에게 줌
            brother[a]++;
            Brother.add(a);
        }
        int BrotherSize = Brother.size();
        
        int answer = 0;
        Set<Integer> CheolSu = new HashSet<>();     //형이 가진 토핑 종류
        for(int a : topping){                       //형에게 하나씩 건네줌

            //형에게 건네준다.
            brother[a]--;
            if(brother[a] == 0){
                BrotherSize--;
            }
            
            //형은 받는다.
            CheolSu.add(a);
            
            if(CheolSu.size() == BrotherSize){
                answer++;
            }
        }
        
        
        return answer;
    }
}