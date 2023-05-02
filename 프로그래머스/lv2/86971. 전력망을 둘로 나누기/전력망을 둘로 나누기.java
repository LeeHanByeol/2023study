import java.util.*;
class Solution {
    
    Set<Integer> A = new HashSet<>();
    Set<Integer> B = new HashSet<>();
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        //Exhaustive Search
        for(int i = 0; i < n-1; i++){
            
            boolean[] isApplied = new boolean[n-1];         //wires applied -> true   
            
            //divide nodes(=#num) into group A and B
            //apply 'i'th wire
            A.add(wires[i][0]);
            B.add(wires[i][1]);
            isApplied[i] = true;
            
            //apply whole wires
            while(!isComplete(isApplied)){
                for(int j = 0; j < n-1; j++){
                    if(!isApplied[j]){    //unapplied wire
                        isApplied[j] = sort(wires[j]);
                    }
                }
            }
            
            //calculate abs
            int diff = (A.size() > B.size()) ? (A.size() - B.size()) : (B.size() - A.size());
            if(diff < answer){
                answer = diff;
            }
            
            //reset
            A.clear();
            B.clear();
        }
        
        return answer;
    }
    
    public boolean sort(int[] wire){
        
        int node1 = wire[0];
        int node2 = wire[1];
        
        if(A.contains(node1)){
            A.add(node2);
            return true;
        }
        if(A.contains(node2)){
            A.add(node1);
            return true;
        }
        if(B.contains(node1)){
            B.add(node2);
            return true;
        }
        if(B.contains(node2)){
            B.add(node1);
            return true;
        }
        
        return false;
    }
    
    public boolean isComplete(boolean[] isApplied){

        //completely apply all wires -> true
        //unapplied wire remains -> false
        for(boolean apply : isApplied){
            if(!apply) return false;
        }
        return true;
    }
}