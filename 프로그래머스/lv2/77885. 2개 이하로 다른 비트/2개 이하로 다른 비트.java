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
        
        if(str.endsWith("0")){      //.....0
            return str.substring(0, str.length()-1) + "1";
        }
        
        if(!str.contains("01")){    //111111
            return "10" + str.substring(1);
        }
        
        //....01111
        int lastIdx = str.lastIndexOf("01");
        
        return str.substring(0, lastIdx) + "10" 
            + ((lastIdx == str.length()-2) ? "" : str.substring(lastIdx+2));
        
    }
}