import java.util.*;
class Solution {

    Map<String, Integer> dict = new HashMap<>();
    static int idx = 0;
    
    public int solution(String word) {
        make_dict("");
        return dict.get(word);
    }
    
    public void make_dict(String word){
        
        dict.put(word, idx++);
        
        if(word.length() == 5) return;
        
        make_dict(word + "A");
        make_dict(word + "E");
        make_dict(word + "I");
        make_dict(word + "O");
        make_dict(word + "U");
        
        return;
    }
}