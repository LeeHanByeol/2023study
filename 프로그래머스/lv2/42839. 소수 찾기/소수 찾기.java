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
        if(n==2 && !checked.contains(2)){
            checked.add(2);
            return true;
        }

        //기존에 구했던 수(중복) or 짝수
        if(checked.contains(n) || (n&1) == 0){
            return false;
        }
        
        //처음 구하는 수
        int end = (int)Math.sqrt(n);
        for(int i = 3; i <= end; i+=2){
            if(n % i == 0){
                checked.add(n);
                return false;
            }
        }
        checked.add(n);
        return true;
    }
    
    
}