public class Solution {
    public boolean isPalindrome(String s) {
         String regex = "([^A-Za-z0-9])";
    String replacement = "";
    s = s.replaceAll(regex, replacement);
    for(int i =0;i<s.length()/2;i++){
        if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(s.length()-1-i)))
            continue;
        else 
            return false;
    }
    return true;

    }
}