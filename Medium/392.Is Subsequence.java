public class Solution {
    //two pointer: only one input string
    public boolean isSubsequence(String s, String t) {
        if(s == null) return true;
        if(t == null) return false;
        
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            j = t.indexOf(s.charAt(i), j);
            if (j < 0) return false;
            j++;
        }
        
        return true;
    }
    
    //Follow up: Binary search for multiple coming string
    public boolean isSubsequence(String s, String t) {
        //O(t.length())
        Map<Character, List<Integer>> myMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!myMap.containsKey(t.charAt(i))) {
                myMap.put(t.charAt(i), new ArrayList<Integer>());
            }
            myMap.get(t.charAt(i)).add(i);
        }
        
        //search: O(s.length() * log(t.length()))
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch= s.charAt(i);

            int nextIndex = getNextIndex(myMap.get(ch), index);
            if (nextIndex < 0) return false;
            index = nextIndex;
        }
        
        return true;
    }
    
    public int getNextIndex(List<Integer> list, int index) {
        if (list == null) return -1;
        int left = 0, right = list.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= index) left = mid + 1;
            else right = mid;
        }
        
        return list.get(left) > index ? list.get(left) : -1;
        
    }
}