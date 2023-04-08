class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;
        
        for(long number : numbers){
            String binary = Long.toBinaryString(number);
            answer[idx++] = Long.parseLong(change(binary), 2);
        }
        return answer;
    }

    
    public String change(String str){
        
        StringBuilder sb = new StringBuilder(str);
        int len = sb.length();
        
        if(sb.charAt(len-1) == '0'){          //.....0
            sb.setCharAt(len-1, '1');        //-> .....1
        }
        else{
            int lastIdx = sb.lastIndexOf("01");

            if(lastIdx == -1){             //111111
                sb.insert(1, '0');        //->10111111
            }
            else{                                       //....01...
                sb.replace(lastIdx, lastIdx+2, "10");   //->....10...
            }
            
        }
        return sb.toString();
    }
}