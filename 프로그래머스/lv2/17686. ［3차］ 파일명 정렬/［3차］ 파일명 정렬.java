import java.util.*;

class Solution {
        
    public String[] solution(String[] files) {
        
        Arrays.sort(files, comp);
        return files;
    }
    
    
    public static Comparator<String> comp = new Comparator<>(){
      
        @Override
        public int compare(String f1, String f2){
            //f1 > f2이면 양수
            //f1 == f2이면 0
            //f1 < f2이면 
                
                
            String[] F1 = split(f1);
            String[] F2 = split(f2);
            
            int head_compare = F1[0].compareToIgnoreCase(F2[0]);
            int num_compare = Integer.parseInt(F1[1]) - Integer.parseInt(F2[1]);
            
            if(head_compare == 0){
                if(num_compare == 0) return 0;      //같을 경우 순서 유지
                return num_compare;
            }
            
            return head_compare;
        }
    };
    
    public static String[] split(String str){
        
        String[] arr = new String[2];
        boolean head = true;
        int start = 0;

        for(int i = 0; i < str.length(); i++){
            
            if(head && isNum(str.charAt(i))){   //숫자 등장 -> head 끝
                arr[0] = str.substring(0, i);
                head = false;
                start = i;
                continue;
            }
            
            if(!head && ( i >= start+5 || !isNum(str.charAt(i)))){    //5개 초과 혹은 문자 등장 -> num 끝
                arr[1] = str.substring(start, i);
                break;
            }
        }
        
        
        if(arr[1] == null){
            arr[1] = str.substring(start);
        }
        return arr;
    }
    
    public static boolean isNum(char c){
        return ('0' <= c && c <= '9');
    }
    
}
