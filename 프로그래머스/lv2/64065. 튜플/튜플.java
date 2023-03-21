import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        //s 전처리
        String[] set = s.substring(1, s.length()-1).split("},*");
        Arrays.sort(set, (a,b)-> a.length()-b.length());

        //
        int[] answer = new int[set.length];
        int idx = 0;
        Set <Integer> duplicate = new HashSet<Integer>();
        for(String a : set){
            String[] cur = a.substring(1).split(",");
            
            for(int i = 0; i < cur.length; i++){
                int num = Integer.parseInt(cur[i]);
                if(duplicate.add(num)){
                    answer[idx++] = num;
                }
            }
        }
        
        return answer;
    }
}