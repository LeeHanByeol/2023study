import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        //data preprocessing        
        Vector<String> set1 = new Vector<>();
        Vector<String> set2 = new Vector<>();
        for(int i = 0; i < str1.length()-1; i++){
            String temp = str1.substring(i, i+2);
            if(!temp.matches(".*[^a-zA-Z].*")){
                set1.add(temp);
            }
        }
        for(int i = 0; i < str2.length()-1; i++){
            String temp = str2.substring(i, i+2);
            if(!temp.matches(".*[^a-zA-Z].*")){
                set2.add(temp);
            }
        }
        
        //both are empty set
        if(set1.size() == 0 && set2.size() == 0){
            return 65536;
        }
        
        //num of Union
        int union = set1.size() + set2.size();
        
        //num of Intersection 
        //O(n^2)
        int intersect = 0;
        for(int i = 0; i < set1.size(); i++){
            for(int j = 0; j < set2.size(); j++){
                if(set1.get(i).equalsIgnoreCase(set2.get(j))){
                    set1.remove(i);
                    set2.remove(j);
                    intersect++;
                    i--;
                    break;
                }
            }
        }
        
        //n(A union B) = n(A) + n(B) - n(A intersect B)
        union -= intersect;
        
        return intersect * 65536 / union;
    }
}