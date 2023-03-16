import java.util.*;     //for using 'Set' class

class Solution {
    public int[] solution(int n, String[] words) {
    
        //Set: 중복 허용x, 순서x
        Set hash = new HashSet();
        hash.add(words[0]);
        char endCh = words[0].charAt(words[0].length()-1);
        
        for(int i = 1; i < words.length; i++){

            char startCh = words[i].charAt(0);
            
            //hash.add는 중복 단어라면 추가하지 않고 false를 반환한다
            if(endCh != startCh || !hash.add(words[i])){    //탈락자 발생
                return new int[]{(i%n + 1), (i/n + 1)};
            }
            
            endCh = words[i].charAt(words[i].length()-1);
        }
        
        return new int[]{0, 0};
    }
}