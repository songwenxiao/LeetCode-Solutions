public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return null;
        }
        int[] res = new int[numCourses];
        int index = 0;
        if (prerequisites.length == 0 || prerequisites[0].length == 0) {
            while (index < numCourses) {
                res[index] = index++;
            }
            return res;
        }
        int[] course = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            int val = prerequisites[i][0];
            int key = prerequisites[i][1];
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<Integer>());
            }
            map.get(key).add(val);
            course[val]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (course[i] == 0) {
                queue.add(i);
                res[index++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (map.get(cur) != null) {
                for (int temp : map.get(cur)) {
                    course[temp]--;
                    if (course[temp] == 0) {
                        queue.offer(temp);
                        res[index++] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (course[i] != 0) {
                return new int[0];
            }
        }
        return res;
    }
}