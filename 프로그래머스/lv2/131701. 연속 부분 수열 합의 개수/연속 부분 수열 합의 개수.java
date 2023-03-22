import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> num_list = new HashSet<>();
        for(int len = 1; len <= elements.length; len++){
            for(int start_idx = 0; start_idx < elements.length; start_idx++){
                int sum = 0;
                for(int i = 0; i < len; i++){
                    int idx = start_idx + i;
                    idx = (idx < elements.length) ? idx : (idx - elements.length);
                    sum += elements[idx];
                }
                num_list.add(sum);
            }
        }
        
        return num_list.size();
    }
}