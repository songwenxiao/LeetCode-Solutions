public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = addVowels();
        int i = 0;
        int j = s.length()-1;
        char[] cs = s.toCharArray();
        while(i<j){
            if(set.contains(cs[i])&&set.contains(cs[j])){
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
                i++;
                j--;
            }else if(!set.contains(cs[i])){
                i++;
            }else {
                j--;
            }
        }
        return new String(cs);
    }
    
    public Set<Character> addVowels(){
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        return set;
    }
}