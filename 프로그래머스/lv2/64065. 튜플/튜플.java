import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        //s 전처리
        String[] set = s.substring(2, s.length()-2).split("[}][,][{]");
        Arrays.sort(set, (a,b)-> a.length()-b.length());
        
        int[] answer = new int[set.length];
        int idx = 0;
        Set <Integer> duplicate = new HashSet<Integer>();
        for(String a : set){
            for(String num : a.split(",")){
                int n = Integer.parseInt(num);
                if(duplicate.add(n)){
                    answer[idx++] = n;
                }
            }
        }
        
        return answer;
    }
}