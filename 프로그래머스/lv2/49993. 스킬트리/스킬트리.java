import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        //선행스킬인지 아닌지 판단하기 위한 set
        Set<Character> set = new HashSet<>(skill.length());
        for(char c : skill.toCharArray()){
            set.add(c);
        }
        
        
        int answer = 0;
        for(String skillTree : skill_trees){
            boolean correctOrder = true;
            int idx = 0;

            for(char c : skillTree.toCharArray()){

                if(!set.contains(c))    //선행스킬이 아닌 스킬
                    continue;
                
                if(skill.charAt(idx++) != c) 
                    correctOrder = false;
            }
            answer += correctOrder ? 1 : 0;   
        }
        
        return answer;
    }
}