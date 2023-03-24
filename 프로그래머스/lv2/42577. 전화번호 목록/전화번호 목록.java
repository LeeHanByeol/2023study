import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
                
        //sort by phone_number's length(DESC)
        Arrays.sort(phone_book, (a,b) -> b.length() - a.length());
        
        //Trie
        Trie tree = new Trie();
        for(int i = 0; i < phone_book.length; i++){
            if(tree.contains(phone_book[i])){
                return false;
            }
            tree.insert(phone_book[i]);
        }
        
        return true;
    }
    
    
    static class Node {
        Map<Character, Node> childNodes = new HashMap<>();  //자식 노드
        boolean isEnd;
    }
    static class Trie {
        
        Node root = new Node();
                
        void insert(String str){
            Node cur = this.root;
            for(int i = 0; i < str.length(); i++){
                //자식노드(hashmap) 중에 해당 문자를 key값으로 갖는 노드가 있다면 해당 노드 반환
                //없으면 key값을 new Node()에 넘겨줌
                cur = cur.childNodes.computeIfAbsent(str.charAt(i), key -> new Node());
            }   
            cur.isEnd = true;
        }
        
        boolean contains(String str){
            Node cur = this.root;
            for(int i = 0; i < str.length(); i++){
                //자식노드 중에 해당 문자를 key값으로 갖는 노드가 있으면 해당 노드 반환
                //없으면 null 반환
                cur = cur.childNodes.getOrDefault(str.charAt(i), null);
                if(cur == null){return false;}
            }
            
            return true;
        }
        
    }
}