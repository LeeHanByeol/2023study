import java.util.*;
class Solution {
    
    Set<Integer> checked = new HashSet<>();
    
    public int solution(String numbers) {
        checked.add(0);
        checked.add(1);        
        
        String[] arr = numbers.split("");
        boolean[] visited = new boolean[arr.length];
        return candidate(arr, "", visited);
    }
    
    public int candidate(String[] arr, String cur, boolean[] visited){
        
        int answer = 0;
        
        if(isPrime(cur)){
            answer++;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                answer += candidate(arr, cur + arr[i], visited);
                visited[i] = false;
            }            
        }        
        return answer;
    }
    
    public boolean isPrime(String number){
        
        if(number.equals("")){
            return false;
        }
        
        int n = Integer.parseInt(number);

        //기존에 구했던 수(중복)
        if(checked.contains(n)){
            return false;
        }
        
        //처음 구하는 수
        int end = (int)Math.sqrt(n);
        for(int i = 2; i <= end; i++){
            if(n % i == 0){
                checked.add(n);
                return false;
            }
        }
        checked.add(n);
        return true;
    }
    
    
}