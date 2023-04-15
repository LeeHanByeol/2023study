import java.util.*;
class Solution {
    
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    public class Node{
        int num;
        int op_num;
        
        public Node(int num, int op_num){
            this.num = num;
            this.op_num = op_num;
        }
    }
    
    public int bfs(int x, int y, int n){
        
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, 0));
        
        while(!queue.isEmpty()){
            
            Node cur = queue.poll();
            if(cur.num == y){
                return cur.op_num;
            }
            
            int result = cur.num + n;
            if(result <= y && !visited.contains(result)){
                visited.add(result);
                queue.add(new Node(result, cur.op_num + 1));
            }
            result = cur.num<<1;
            if(result <= y && !visited.contains(result)){
                visited.add(result);
                queue.add(new Node(result, cur.op_num + 1));
            }
            result = cur.num*3;
            if(result <= y && !visited.contains(result)){
                visited.add(result);
                queue.add(new Node(result, cur.op_num + 1));
            }
        }
        
        return -1;
        
    }
}