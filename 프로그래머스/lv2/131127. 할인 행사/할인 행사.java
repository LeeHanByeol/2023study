import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for(int i = 0; i <= discount.length - 10; i++){
            Map<String, Integer> tenDays = new HashMap<>();
            
            for(int j = i; j < i + 10; j++){
                int num = tenDays.getOrDefault(discount[j], 0);
                tenDays.put(discount[j], num+1);
            }
            boolean ans = true;
            for(int j = 0; j < want.length; j++){
                if(tenDays.getOrDefault(want[j], 0) != number[j]){
                    ans = false;
                    break;
                }
            }
            answer += ans ? 1 : 0;
        }
        
        return answer;
    }
}