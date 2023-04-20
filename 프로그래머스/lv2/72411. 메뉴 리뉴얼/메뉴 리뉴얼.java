import java.util.*;
class Solution {

    Map<Integer, Map<String, Integer>> candidate = new HashMap<>();       //메뉴 구성 길이, 구성, 주문 횟수
    Set<Integer> courses = new HashSet<>();                               //메뉴 구성의 길이
    
    public String[] solution(String[] orders, int[] course) {
        
        for(int a : course){
            courses.add(a);
            candidate.put(a, new HashMap<>());
        }
        
        for(String str : orders){
            char[] order = str.toCharArray();
            Arrays.sort(order);
            dfs(order, new StringBuilder(), 0, new boolean[order.length]);
        }
                
        LinkedList<String> ans = new LinkedList<>();
        for(int len : course){
            Map<String, Integer> menu = candidate.get(len);
            int max = 2;
            
            LinkedList<String> temp = new LinkedList<>();
            for(Map.Entry<String, Integer> entity : menu.entrySet()){
                int order_num = entity.getValue();
                if(order_num < max){    
                    continue;
                }
                else if(order_num > max){
                    temp.clear();
                }
                max = order_num;
                temp.add(entity.getKey());                          
            }
            ans.addAll(temp);
        }
        
        Collections.sort(ans);
        String[] answer = ans.toArray(new String[0]);
        return answer;
    }
    
    
    public void dfs(char[] str, StringBuilder sb, int cur, boolean[] visited){
        
        int len = sb.length();
        if(courses.contains(len)){
            String comb = sb.toString();
            int order = candidate.get(len).getOrDefault(comb, 0);
            candidate.get(len).put(comb, order + 1);
        }
        
        for(int i = cur; i < str.length; i++){
            if(!visited[i]){
                sb.append(str[i]);
                visited[i] = true;
                dfs(str, sb, i+1, visited);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
        }
        return;
    }
    

}