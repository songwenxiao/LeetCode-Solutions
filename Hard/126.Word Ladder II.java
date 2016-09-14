public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> results = new ArrayList<List<String>>();
        wordList.add(endWord);
        
        Queue<List<String>> paths = new LinkedList<List<String>>();
        List<String> path0 = new LinkedList<String>();
        
        path0.add(beginWord);
        paths.add(path0);
        
        int level = 1, lastLevel = Integer.MAX_VALUE;
        Set<String> wordsPerLevel = new HashSet<String>();
        
        while(!paths.isEmpty()){
            List<String> path = paths.poll();
            if(path.size()>level){
                wordList.removeAll(wordsPerLevel);
                wordsPerLevel.clear();
                level = path.size();
                if(level>lastLevel)
                    break;
            }
            
            String last = path.get(level-1);
            char[] chars = last.toCharArray();
            for (int index = 0; index < last.length(); index++) {
                char original = chars[index];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[index] = c;
                    String next = new String(chars);
                    if (wordList.contains(next)) {
                        wordsPerLevel.add(next);
                        List<String> nextPath = new LinkedList<String>(path);
                        nextPath.add(next);
                        if (next.equals(endWord)) {
                            results.add(nextPath);
                            lastLevel = level; // curr level is the last level
                        }else {
                            paths.offer(nextPath);
                        }
                    }
                    chars[index] = original;
                }
            }
        }
        return results;
    }
}