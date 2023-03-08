class Solution {
    public String solution(String s) {
        
                
        String[] number = s.split(" ");
        int max = Integer.parseInt(number[0]);
        int min = Integer.parseInt(number[0]);
        
        for(int i = 1; i < number.length; i++){
            if(max < Integer.parseInt(number[i])){
                max = Integer.parseInt(number[i]);
            }
            if(min > Integer.parseInt(number[i])){
                min = Integer.parseInt(number[i]);
            }
        }
        
        String answer = Integer.toString(min) + " "+ Integer.toString(max);        
        return answer;
    }
}